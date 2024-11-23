package LAB4;

public class GasStation implements Refuelable {
    @Override
    public void refuel(Car car, CarsCount count) {
        System.out.println("Refueling gas car " + car.getId() + ".");
        int currentNrGasCars = count.getNrGasCars();
        count.setNrGasCars(currentNrGasCars + 1);
        count.setConsumtionGasCars(car.getConsumption() + count.getConsumtionGasCars());
    }
}
