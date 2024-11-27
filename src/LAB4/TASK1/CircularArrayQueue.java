package LAB4.TASK1;

import LAB4.TASK1.Car;

import java.util.Queue;

public class CircularArrayQueue implements QueueInterface {
    private int front;
    private int rear;
    private int size;
    private Car[] queue;

    public CircularArrayQueue(int capacity) {
        front = 0;
        rear = -1;
        size = 0;
        this.queue = new Car[capacity];
    }

    @Override
    public Queue<Car> initializeQueue() {
        throw new UnsupportedOperationException("Custom queue doesn't support Queue initialization");
    }

    @Override
    public void addElementQueue(Queue<Car> unused, Car car) {
        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = car;
        size++;
    }

    @Override
    public Car deleteElementQueue(Queue<Car> unused) {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        Car removedCar = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        return removedCar;
    }

    @Override
    public Car getPeekElementQueue(Queue<Car> unused) {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        return queue[front];
    }

    public int length () {
        return size;
    }
}
