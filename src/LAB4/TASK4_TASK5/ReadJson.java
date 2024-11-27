package LAB4.TASK4_TASK5;

import LAB4.TASK1.Car;
import LAB4.TASK1.QueueCars;
import LAB4.TASK1.RefuelStationQueue;
import LAB4.TASK1.ServiceStationQueue;
import LAB4.TASK2.*;
import LAB4.TASK3.CarStation;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.Semaphore;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class ReadJson {


    private static final Semaphore semaphore = new Semaphore(2);


    private static Car tryReadFile(Path filePath, ObjectMapper mapper, int maxRetries, long delayMillis) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                return mapper.readValue(filePath.toFile(), Car.class);
            } catch (IOException e) {
                attempts++;
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        System.err.println("Failed to read file after retries: " + filePath.getFileName());
        return null;
    }


    public static void readJsonData(String path, Queue<Car> queue, CarsCount count) throws IOException, InterruptedException {
        Path folderPath = Paths.get(path);
        ObjectMapper mapper = new ObjectMapper();
        int filesProcessed = 0;

        QueueCars queueCarsObject = new QueueCars();
        RefuelStationQueue refuelStationObject = new RefuelStationQueue();
        ServiceStationQueue serviceStationObject = new ServiceStationQueue();

        Queue<Car> queueCars = queueCarsObject.initializeQueue();
        Queue<Car> refuelStationQueue = refuelStationObject.initializeQueue();
        Queue<Car> serviceStationQueue = serviceStationObject.initializeQueue();

        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        CarStation carStation = new CarStation(peopleDinner, robotDinner, electricStation, gasStation,
                queueCarsObject, refuelStationObject, serviceStationObject);

        // Process existing JSON files in the directory
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.json")) {
            for (Path filePath : stream) {
                if (filesProcessed >= 30) break;

                Car car = tryReadFile(filePath, mapper, 3, 1000);
                if (car != null) {
                    synchronized (queue) {
                        carStation.addCar(car, queue, refuelStationQueue, serviceStationQueue);
                        queue.add(car);
                        System.out.println("\nAdded car to queue: " + car);

                        if (car.getType().equalsIgnoreCase("electric")) {
                            count.incrementNrElectricCars();
                            count.addConsumptionElectricCars(car.getConsumption());
                        } else if (car.getType().equalsIgnoreCase("gas")) {
                            count.incrementNrGasCars();
                            count.addConsumptionGasCars(car.getConsumption());
                        }

                        if (car.getIsDining()) {
                            count.incrementNrCarsDined();
                        } else {
                            count.incrementNrCarsNotDined();
                        }

                        if (car.getPassengers().equalsIgnoreCase("people")) {
                            count.incrementNrCarsWithPeople();
                        } else if (car.getPassengers().equalsIgnoreCase("robots")) {
                            count.incrementNrCarsWithRobots();
                        }

                        new Thread(() -> serveCarWithSemaphore(carStation, queue, refuelStationQueue, serviceStationQueue)).start();
                    }
                    filesProcessed++;
                }
            }
        }


        // Monitor new files in the folder
        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            folderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            boolean keepRunning = true;

            while (keepRunning && filesProcessed < 30) {
                WatchKey key = watchService.take();

                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        Path createdFile = folderPath.resolve((Path) event.context());
                        if (createdFile.toString().endsWith(".json")) {
                            Thread.sleep(500);
                            Car car = tryReadFile(createdFile, mapper, 3, 1000);
                            if (car != null) {
                                synchronized (queue) {
                                    carStation.addCar(car, queue, refuelStationQueue, serviceStationQueue);
                                    System.out.println("\nAdded car to queue: " + car);

                                    if (car.getType().equalsIgnoreCase("electric")) {
                                        count.incrementNrElectricCars();
                                        count.addConsumptionElectricCars(car.getConsumption());
                                    } else if (car.getType().equalsIgnoreCase("gas")) {
                                        count.incrementNrGasCars();
                                        count.addConsumptionGasCars(car.getConsumption());
                                    }

                                    if (car.getIsDining()) {
                                        count.incrementNrCarsDined();
                                    } else {
                                        count.incrementNrCarsNotDined();
                                    }

                                    if (car.getPassengers().equalsIgnoreCase("people")) {
                                        count.incrementNrCarsWithPeople();
                                    } else if (car.getPassengers().equalsIgnoreCase("robots")) {
                                        count.incrementNrCarsWithRobots();
                                    }

                                    new Thread(() -> serveCarWithSemaphore(carStation, queue, refuelStationQueue, serviceStationQueue)).start();
                                }
                                filesProcessed++;


                                if (filesProcessed >= 30) {
                                    keepRunning = false;
                                    break;
                                }
                            }
                        }
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    System.err.println("Watch key is no longer valid. Exiting...");
                    break;
                }
            }
        }
    }

    private static void serveCarWithSemaphore(CarStation carStation, Queue<Car> queue,
                                              Queue<Car> refuelStationQueue,
                                              Queue<Car> serviceStationQueue) {
        try {
            semaphore.acquire();
            carStation.serveCars(queue, refuelStationQueue, serviceStationQueue);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted while serving car");
        } finally {
            semaphore.release();
        }
    }
}
