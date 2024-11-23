package LAB4;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class SemaphoreServing {
    public void servingCars(Queue<Car> queueCars, Queue<Car> refuelStationQueue, Queue<Car> serviceStationQueue) throws IOException, InterruptedException {

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

        while (!queueCars.isEmpty()) {
            Car carInLine;

            synchronized (queueCars) {
                carInLine = queueCars.poll();
            }

            if (carInLine != null) {
                final Car currentCar = carInLine;

                new Thread(() -> {
                    try {
                        semaphore.acquire();

                        carStation.addCar(currentCar, queueCars, refuelStationQueue, serviceStationQueue);
                        System.out.println("Processed car: " + currentCar);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        semaphore.release();
                        latch.countDown();
                    }
                }).start();
            }
        }

        latch.await();
        carStation.serveCars(queueCars, refuelStationQueue, serviceStationQueue, new CarsCount());
    }
}
