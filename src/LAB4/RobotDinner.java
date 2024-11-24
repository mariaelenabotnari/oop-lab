package LAB4;

public class RobotDinner implements Dineable {
    @Override
    public void serveDinner(Car car) {
        System.out.println("Dinner is served to robots in car " + car.getId() + ".");
        //count.incrementNrCarsDined();
    }
}
