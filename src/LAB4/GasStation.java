package LAB4;

public class GasStation implements Refuelable {
    @Override
    public void refuel(Car car) {
        System.out.println("Refueling gas car " + car.getId() + ".");
        //count.incrementNrGasCars();
        //count.addConsumptionGasCars(car.getConsumption());
    }
}
