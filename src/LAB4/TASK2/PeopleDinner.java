package LAB4.TASK2;

import LAB4.TASK1.Car;

public class PeopleDinner implements Dineable {
    @Override
    public void serveDinner(Car car) {
        System.out.println("Serving dinner to people in the car " + car.getId() + ".");
    }
}
