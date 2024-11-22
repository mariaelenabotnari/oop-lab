package LAB4;

public class ElectricStation implements Refuelable {
    @Override
    public void refuel(Car car, CarsCount count) {
        System.out.println("Refueling electric car " + car.getId() + ".");
        count.nrElectricCars++;
        count.consumptionElectricCars = car.getConsumption() + count.consumptionElectricCars;
    }
}
