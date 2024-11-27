package LAB4.TASK2;

import LAB4.TASK1.Car;

public class GasStation implements Refuelable {
    @Override
    public void refuel(Car car) {
        System.out.println("Refueling gas car " + car.getId() + ".");
    }
}
