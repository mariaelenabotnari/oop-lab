package LAB4;

public class PeopleDinner implements Dineable {
    @Override
    public void serveDinner(Car car) {
        System.out.println("Serving dinner to people in the car " + car.getId() + ".");
        //count.incrementNrCarsDined();
    }
}
