package LAB4.TASK1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListQueueTest {

    ArrayListQueue carQueue = new ArrayListQueue();

    Car car1 = new Car(1, "electric", "people", false, 30);
    Car car2 = new Car(2, "gas", "people", true, 10);
    Car car3 = new Car(3, "electric", "robots", false, 10);

    @Test
    public void testAddElement () {

        carQueue.addElementQueue(null, car1);
        carQueue.addElementQueue(null, car2);
        carQueue.addElementQueue(null, car3);

        assertEquals(3, carQueue.size(), "Queue should have 3 objects");
    }

    @Test
    public void testRemoveElement () {

        carQueue.addElementQueue(null, car1);
        carQueue.addElementQueue(null, car2);
        carQueue.addElementQueue(null, car3);

        Car removedObject = carQueue.deleteElementQueue(null);
        assertEquals(car1, removedObject, "The removed object should be the first element added in the queue.");

        assertEquals(2, carQueue.size(), "Queue should have 2 objects after removal. ");
    }

    @Test
    public void testPeek () {

        carQueue.addElementQueue(null, car1);
        carQueue.addElementQueue(null, car2);
        carQueue.addElementQueue(null, car3);

        Car front = carQueue.getPeekElementQueue(null);
        assertEquals(car1, front, "The front object should be the first element added in the queue.");
    }


}
