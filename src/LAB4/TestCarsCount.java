package LAB4;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class TestCarsCount {

    @Test
    public void testCount() {
        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", true, 10);
        Car car4 = new Car(4, "electric", "robots", false, 13);

        CarsCount count = new CarsCount();
        QueueCars queueObject = new QueueCars();
        Queue<Car> carQueue = queueObject.initializeQueue();

        queueObject.addElementQueue(carQueue, car1);
        queueObject.addElementQueue(carQueue, car2);
        queueObject.addElementQueue(carQueue, car3);
        queueObject.addElementQueue(carQueue, car4);

        for (Car car : carQueue) {
            if (car.getPassengers().equals("robots")) {
                count.incrementNrCarsWithRobots();
                if (car.getIsDining()) {
                    count.incrementNrCarsDined();
                } else {
                    count.incrementNrCarsNotDined();
                }
            } else if (car.getPassengers().equals("people")) {
                count.incrementNrCarsWithPeople();
                if (car.getIsDining()) {
                    count.incrementNrCarsDined();
                } else {
                    count.incrementNrCarsNotDined();
                }
            }

            if (car.getType().equals("electric")) {
                count.incrementNrElectricCars();
                count.addConsumptionElectricCars(car.getConsumption());
            } else if (car.getType().equals("gas")) {
                count.incrementNrGasCars();
                count.addConsumptionGasCars(car.getConsumption());
            }
        }

        assertEquals(3, count.getNrElectricCars());
        assertEquals(1, count.getNrGasCars());
        assertEquals(2, count.getNrCarsWithPeople());
        assertEquals(2, count.getNrCarsWithRobots());
        assertEquals(2, count.getNrCarsDined());
        assertEquals(2, count.getNrCarsNotDined());
        assertEquals(53, count.getConsumptionElectricCars());
        assertEquals(10, count.getConsumptionGasCars());
    }
}
