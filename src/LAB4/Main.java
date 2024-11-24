package LAB4;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static LAB4.ReadJson.readJsonData;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Queue<Car> queueCars = new ConcurrentLinkedQueue<>();
        Queue<Car> refuelStationQueue = new ConcurrentLinkedQueue<>();
        Queue<Car> serviceStationQueue = new ConcurrentLinkedQueue<>();

        String path = "C:\\Users\\maria\\IdeaProjects\\OOP\\queue";
        readJsonData(path, queueCars);

        CarsCount count = new CarsCount();

        SemaphoreServing semaphoreServing = new SemaphoreServing();
        semaphoreServing.servingCars(queueCars, refuelStationQueue, serviceStationQueue, count);

        System.out.println(count);
    }
}
