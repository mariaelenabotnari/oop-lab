package LAB4;

public class ElectricStation implements Refuelable {
    @Override
    public void refuel(Car car, CarsCount count) {
        System.out.println("Refueling electric car " + car.getId() + ".");
        int currentElectricCars = count.getNrElectricCars();
        count.setNrElectricCars(currentElectricCars + 1);
        count.setConsumptionElectricCars(car.getConsumption() + count.getConsumptionElectricCars());
    }
}
