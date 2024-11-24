package LAB4;

public class ElectricStation implements Refuelable {
    @Override
    public void refuel(Car car) {
        System.out.println("Refueling electric car " + car.getId() + ".");
        //count.incrementNrElectricCars();
        //count.addConsumptionElectricCars(car.getConsumption());
    }
}
