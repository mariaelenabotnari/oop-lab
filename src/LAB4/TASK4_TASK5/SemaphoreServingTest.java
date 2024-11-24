package LAB4.TASK4_TASK5;

import LAB4.TASK1.Car;
import LAB4.TASK1.QueueCars;
import LAB4.TASK1.RefuelStationQueue;
import LAB4.TASK1.ServiceStationQueue;
import LAB4.TASK2.CarsCount;
import org.junit.jupiter.api.Test;
import java.util.Queue;

import static LAB4.TASK4_TASK5.ReadJson.readJsonData;
import static org.junit.jupiter.api.Assertions.*;

public class SemaphoreServingTest {

    @Test
    public void testServingCars() throws Exception {
        QueueCars queueCarsObject = new QueueCars();
        Queue<Car> queueCars = queueCarsObject.initializeQueue();

        RefuelStationQueue refuelStationQueueObject = new RefuelStationQueue();
        Queue<Car> refuelStationQueue = refuelStationQueueObject.initializeQueue();

        ServiceStationQueue serviceStationQueueObject = new ServiceStationQueue();
        Queue<Car> serviceStationQueue = serviceStationQueueObject.initializeQueue();

        CarsCount count = new CarsCount();

        readJsonData("src/LAB4/CarJSON", queueCars);

        SemaphoreServing semaphoreServing = new SemaphoreServing();
        semaphoreServing.servingCars(queueCars, refuelStationQueue, serviceStationQueue, count);

        assertEquals(0, queueCars.size(), "queueCars should be empty after processing.");
        assertEquals(1, serviceStationQueue.size(),
                "serviceStationQueue should contain only cars marked for dining.");
    }

}
