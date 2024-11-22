package LAB4;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCars implements QueueInterface {
    @Override
    public Queue<Car> initializeQueue() {
        return new LinkedList<Car>();
    }

    @Override
    public void addElementQueue(Queue<Car> queue, Car car) {
        queue.offer(car);
    }

    @Override
    public Car deleteElementQueue(Queue<Car> queue) {
        return queue.poll();
    }

    @Override
    public Car getPeekElementQueue(Queue<Car> queue) {
        return queue.peek();
    }
}
