package LAB4;

import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testAddElement () {
        QueueCars queueObject = new QueueCars();
        Queue<Car> carQueue = queueObject.initializeQueue();
        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", false, 10);

        queueObject.addElementQueue(carQueue, car1);
        queueObject.addElementQueue(carQueue, car2);
        queueObject.addElementQueue(carQueue, car3);

        assertEquals(3, carQueue.size(), "Queue should have 3 objects");
    }

    @Test
    public void testRemoveElement () {
        RefuelStationQueue queueObject = new RefuelStationQueue();
        Queue<Car> refuelQueue = queueObject.initializeQueue();
        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", false, 10);

        queueObject.addElementQueue(refuelQueue, car1);
        queueObject.addElementQueue(refuelQueue, car2);
        queueObject.addElementQueue(refuelQueue, car3);

        Car removedObject = queueObject.deleteElementQueue(refuelQueue);
        assertEquals(car1, removedObject, "The removed object should be the first element added in the queue.");

        assertEquals(2, refuelQueue.size(), "Queue should have 2 objects after removal. ");
    }

    @Test
    public void testPeek () {
        ServiceStationQueue queueObject = new ServiceStationQueue();
        Queue<Car> serviceStationQueue = queueObject.initializeQueue();
        Car car1 = new Car(1, "electric", "people", false, 30);
        Car car2 = new Car(2, "gas", "people", true, 10);
        Car car3 = new Car(3, "electric", "robots", false, 10);

        queueObject.addElementQueue(serviceStationQueue, car1);
        queueObject.addElementQueue(serviceStationQueue, car2);
        queueObject.addElementQueue(serviceStationQueue, car3);

        Car front = queueObject.getPeekElementQueue(serviceStationQueue);
        assertEquals(car1, front, "The front object should be the first element added in the queue.");
    }


}
