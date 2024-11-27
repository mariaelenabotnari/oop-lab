package LAB4.TASK2;

import LAB4.TASK1.Car;

public class RobotDinner implements Dineable {
    @Override
    public void serveDinner(Car car) {
        System.out.println("Dinner is served to robots in car " + car.getId() + ".");
    }
}
