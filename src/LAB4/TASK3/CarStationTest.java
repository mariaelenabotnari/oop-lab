package LAB4.TASK3;

import LAB4.TASK1.Car;
import LAB4.TASK1.QueueCars;
import LAB4.TASK1.RefuelStationQueue;
import LAB4.TASK1.ServiceStationQueue;
import LAB4.TASK2.*;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class CarStationTest {

    @Test
    public void testCarStation() {
        QueueCars queueCarsObject = new QueueCars();
        Queue<Car> queueCars = queueCarsObject.initializeQueue();

        RefuelStationQueue refuelStationObject = new RefuelStationQueue();
        Queue<Car> refuelStationQueue = refuelStationObject.initializeQueue();

        ServiceStationQueue serviceStationObject = new ServiceStationQueue();
        Queue<Car> serviceStationQueue = serviceStationObject.initializeQueue();

        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        CarStation carStation = new CarStation(peopleDinner, robotDinner, electricStation, gasStation, queueCarsObject, refuelStationObject, serviceStationObject);

        CarsCount count = new CarsCount();

        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", false, 10);
        Car car4 = new Car(4, "electric", "robots", false, 13);

        carStation.addCar(car1, queueCars, refuelStationQueue, serviceStationQueue);
        carStation.addCar(car2, queueCars, refuelStationQueue, serviceStationQueue);
        carStation.addCar(car3, queueCars, refuelStationQueue, serviceStationQueue);
        carStation.addCar(car4, queueCars, refuelStationQueue, serviceStationQueue);

        int expectedServiceQueueSize = 1;
        assertEquals(expectedServiceQueueSize, serviceStationQueue.size(),
                "serviceStationQueue should contain only cars marked for dining.");

        carStation.serveCars(queueCars, refuelStationQueue, serviceStationQueue);

        assertEquals(0, queueCars.size(), "queueCars should be empty after processing.");
    }
}
