package LAB4.TASK1;

import java.util.ArrayList;
import java.util.Queue;

public class ArrayListQueue implements QueueInterface {
    private ArrayList<Car> queue = new ArrayList<>();

    @Override
    public Queue<Car> initializeQueue() {
        queue = new ArrayList<>();
        return null;
    }

    @Override
    public void addElementQueue(Queue<Car> queueCars, Car car) {
        queue.add(car);
    }

    @Override
    public Car deleteElementQueue(Queue<Car> queueCars) {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    @Override
    public Car getPeekElementQueue(Queue<Car> queueCars) {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    public int size () {
        return queue.size();
    }
}