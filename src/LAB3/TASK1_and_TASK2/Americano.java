package LAB3.TASK1_and_TASK2;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(String drinkType, Intensity coffeeIntensity, int mlOfWater) {
        super(drinkType, coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Millimeters of water added to the drink: " + this.mlOfWater);
    }
}
