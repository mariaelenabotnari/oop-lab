package LAB4;

import java.awt.*;

public class RobotDinner implements Dineable {
    @Override
    public void serveDinner (Car car, CarsCount count) {
        System.out.println("Dinner is served to robots in car " + car.getId() + ".");
        count.nrCarsDined++;
    }
}
