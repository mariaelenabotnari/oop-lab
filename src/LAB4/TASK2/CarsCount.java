package LAB4.TASK2;

import java.util.concurrent.atomic.AtomicInteger;

public class CarsCount {
    private final AtomicInteger nrElectricCars = new AtomicInteger();
    private final AtomicInteger nrGasCars = new AtomicInteger();
    private final AtomicInteger nrCarsWithPeople = new AtomicInteger();
    private final AtomicInteger nrCarsWithRobots = new AtomicInteger();
    private final AtomicInteger nrCarsDined = new AtomicInteger();
    private final AtomicInteger nrCarsNotDined = new AtomicInteger();
    private final AtomicInteger consumptionElectricCars = new AtomicInteger();
    private final AtomicInteger consumptionGasCars = new AtomicInteger();

    public int getNrElectricCars() {
        return nrElectricCars.get();
    }

    public void incrementNrElectricCars() {
        nrElectricCars.incrementAndGet();
    }

    public int getNrGasCars() {
        return nrGasCars.get();
    }

    public void incrementNrGasCars() {
        nrGasCars.incrementAndGet();
    }

    public int getNrCarsWithPeople() {
        return nrCarsWithPeople.get();
    }

    public void incrementNrCarsWithPeople() {
        nrCarsWithPeople.incrementAndGet();
    }

    public int getNrCarsWithRobots() {
        return nrCarsWithRobots.get();
    }

    public void incrementNrCarsWithRobots() {
        nrCarsWithRobots.incrementAndGet();
    }

    public int getNrCarsDined() {
        return nrCarsDined.get();
    }

    public void incrementNrCarsDined() {
        nrCarsDined.incrementAndGet();
    }

    public int getNrCarsNotDined() {
        return nrCarsNotDined.get();
    }

    public void incrementNrCarsNotDined() {
        nrCarsNotDined.incrementAndGet();
    }

    public int getConsumptionElectricCars() {
        return consumptionElectricCars.get();
    }

    public void addConsumptionElectricCars(int consumption) {
        consumptionElectricCars.addAndGet(consumption);
    }

    public int getConsumptionGasCars() {
        return consumptionGasCars.get();
    }

    public void addConsumptionGasCars(int consumption) {
        consumptionGasCars.addAndGet(consumption);
    }

    @Override
    public String toString() {
        return String.format(
                "\nCars Count:\n" +
                        "------------------------------\n" +
                        "Electric Cars: %d\n" +
                        "Gas Cars: %d\n" +
                        "Cars with People: %d\n" +
                        "Cars with Robots: %d\n" +
                        "Cars that Dined: %d\n" +
                        "Cars that Didn't Dine: %d\n" +
                        "Electric Cars Consumption: %d\n" +
                        "Gas Cars Consumption: %d\n",
                getNrElectricCars(),
                getNrGasCars(),
                getNrCarsWithPeople(),
                getNrCarsWithRobots(),
                getNrCarsDined(),
                getNrCarsNotDined(),
                getConsumptionElectricCars(),
                getConsumptionGasCars()
        );
    }
}
