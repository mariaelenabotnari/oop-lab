package LAB4;

public class GasStation implements Refuelable {
    @Override
    public void refuel(Car car, CarsCount count) {
        System.out.println("Refueling gas car " + car.getId() + ".");
        count.nrGasCars++;
        count.consumtionGasCars = car.getConsumption() + count.consumtionGasCars;
    }
}
