package LAB4;

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

        CarStation carStation = new CarStation(peopleDinner, robotDinner, electricStation, gasStation);

        CarsCount count = new CarsCount();

        carStation.addCar(queueCars, refuelStationQueue, serviceStationQueue);
        carStation.serveCars(queueCars, refuelStationQueue, serviceStationQueue, count);

        int expectedRefuelQueueSize = queueCars.size();
        int expectedServiceQueueSize = (int) queueCars.stream().filter(Car::getIsDining).count();

        carStation.addCar(queueCars, refuelStationQueue, serviceStationQueue);
        assertTrue(queueCars.isEmpty(), "queueCars should be empty after processing.");
        assertEquals(expectedRefuelQueueSize, refuelStationQueue.size(),
                "refuelStationQueue should contain all cars from queueCars.");
        assertEquals(expectedServiceQueueSize, serviceStationQueue.size(),
                "serviceStationQueue should contain only cars marked for dining.");
    }
}
