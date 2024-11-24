package LAB4;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreServing {
    public void servingCars(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue, CarsCount count) throws IOException, InterruptedException {
        QueueCars queueCarsObject = new QueueCars();
        RefuelStationQueue refuelStationObject = new RefuelStationQueue();
        ServiceStationQueue serviceStationObject = new ServiceStationQueue();

        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        CarStation carStation = new CarStation(peopleDinner, robotDinner, electricStation, gasStation, queueCarsObject, refuelStationObject, serviceStationObject);

        Semaphore semaphore = new Semaphore(2);
        CountDownLatch latch = new CountDownLatch(queueCars.size());

        Queue<Car> threadSafeQueueCars = new ConcurrentLinkedQueue<>(queueCars);

        while (!queueCars.isEmpty()) {
            Car carInLine;
            synchronized (threadSafeQueueCars) {
                carInLine = queueCars.poll();;
            }

            if (carInLine != null) {
                final Car currentCar = carInLine;

                new Thread(() -> {
                    try {
                        semaphore.acquire();
                        carStation.addCar(currentCar, threadSafeQueueCars, refuelStationQueue, serviceStationQueue);

                        if (currentCar.getType().equalsIgnoreCase("electric")) {
                            count.incrementNrElectricCars();
                            count.addConsumptionElectricCars(currentCar.getConsumption());
                        } else if (currentCar.getType().equalsIgnoreCase("gas")) {
                            count.incrementNrGasCars();
                            count.addConsumptionGasCars(currentCar.getConsumption());
                        }

                        if (currentCar.getIsDining()) {
                            count.incrementNrCarsDined();
                        } else {
                            count.incrementNrCarsNotDined();
                        }

                        if (currentCar.getPassengers().equalsIgnoreCase("people")) {
                            count.incrementNrCarsWithPeople();
                        } else if (currentCar.getPassengers().equalsIgnoreCase("robots")) {
                            count.incrementNrCarsWithRobots();
                        }

                        System.out.println("Processed car: " + currentCar);

                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        semaphore.release();
                        latch.countDown();
                    }
                }).start();
            }
        }

        latch.await();
        System.out.println("\nServing the cars:");
        carStation.serveCars(threadSafeQueueCars, refuelStationQueue, serviceStationQueue);
    }
}
