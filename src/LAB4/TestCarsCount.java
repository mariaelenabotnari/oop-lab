package LAB4;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarsCount {

    @Test
    public void testCount () {
        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", false, 10);
        Car car4 = new Car(4, "electric", "robots", false, 13);

        CarsCount count = new CarsCount();
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();

        QueueCars queueObject = new QueueCars();
        Queue<Car> carQueue = queueObject.initializeQueue();

        queueObject.addElementQueue(carQueue, car1);
        queueObject.addElementQueue(carQueue, car2);
        queueObject.addElementQueue(carQueue, car3);
        queueObject.addElementQueue(carQueue, car4);

        for (Car car : carQueue) {
            if (car.getPassengers().equals("robots")) {
                count.nrCarsWithRobots++;
            }

            if (car.getPassengers().equals("people")) {
                count.nrCarsWithPeople++;
            }

            if (car.getIsDining() && car.getPassengers().equals("robots")) {
                robotDinner.serveDinner(car, count);
            }

            if (car.getIsDining() && car.getPassengers().equals("people")) {
                peopleDinner.serveDinner(car, count);
            }

            if (car.getType().equals("electric")) {
                electricStation.refuel(car, count);
            }

            if (car.getType().equals("gas")) {
                gasStation.refuel(car, count);
            }
        }

        count.nrCarsNotDined = carQueue.size() - count.nrCarsDined;


        assertEquals(3, count.nrElectricCars, "The number of electric cars should be 3.");
        assertEquals(1, count.nrGasCars, "The number of gas cars should be 1.");
        assertEquals(2, count.nrCarsWithPeople, "The number of cars with people should be 2.");
        assertEquals(2, count.nrCarsWithRobots, "The number of cars with robots should be 2.");
        assertEquals(1, count.nrCarsDined, "The number of cars that dined should be 1");
        assertEquals(3, count.nrCarsNotDined, "The number of electric cars that didn't dine should be 3.");
        assertEquals(53, count.consumptionElectricCars, "The amount consumed by the electric cars should be 53.");
        assertEquals(10, count.consumtionGasCars, "The amount consumed by the gas cars should be 10.");
    }
}
