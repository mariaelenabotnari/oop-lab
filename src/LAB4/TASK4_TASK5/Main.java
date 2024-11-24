package LAB4.TASK4_TASK5;
import LAB4.TASK1.Car;
import LAB4.TASK1.QueueCars;
import LAB4.TASK1.RefuelStationQueue;
import LAB4.TASK1.ServiceStationQueue;
import LAB4.TASK2.CarsCount;

import java.io.IOException;
import java.util.Queue;

import static LAB4.TASK4_TASK5.ReadJson.readJsonData;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        QueueCars queueCarsObject = new QueueCars();
        Queue<Car> queueCars = queueCarsObject.initializeQueue();

        RefuelStationQueue refuelStationQueueObject = new RefuelStationQueue();
        Queue<Car> refuelStationQueue = refuelStationQueueObject.initializeQueue();

        ServiceStationQueue serviceStationQueueObject = new ServiceStationQueue();
        Queue<Car> serviceStationQueue = serviceStationQueueObject.initializeQueue();

        String path = "C:\\Users\\maria\\IdeaProjects\\OOP\\queue";
        readJsonData(path, queueCars);

        CarsCount count = new CarsCount();

        SemaphoreServing semaphoreServing = new SemaphoreServing();
        semaphoreServing.servingCars(queueCars, refuelStationQueue, serviceStationQueue, count);

        System.out.println(count);
    }
}
