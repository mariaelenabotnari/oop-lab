package LAB4;

import java.util.Queue;

public interface QueueInterface {

    Queue<Car> initializeQueue();

    void addElementQueue(Queue<Car> queue, Car car);

    Car deleteElementQueue(Queue<Car> queue);

    Car getPeekElementQueue(Queue<Car> queue);

}
