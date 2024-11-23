package LAB4;

import org.junit.jupiter.api.Test;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static LAB4.ReadJson.readJsonData;
import static org.junit.jupiter.api.Assertions.*;

public class SemaphoreServingTest {

    @Test
    public void testServingCars() throws Exception {
        Queue<Car> queueCars = new ConcurrentLinkedQueue<>();
        Queue<Car> refuelStationQueue = new ConcurrentLinkedQueue<>();
        Queue<Car> serviceStationQueue = new ConcurrentLinkedQueue<>();

        readJsonData("src/LAB4/CarJSON", queueCars);

        SemaphoreServing semaphoreServing = new SemaphoreServing();
        semaphoreServing.servingCars(queueCars, refuelStationQueue, serviceStationQueue);

        assertEquals(0, queueCars.size(), "queueCars should be empty after processing.");
        assertEquals(1, serviceStationQueue.size(),
                "serviceStationQueue should contain only cars marked for dining.");
    }

}
