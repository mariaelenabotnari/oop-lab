package LAB3.TASK1_and_TASK2;

public class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(String drinkType, Intensity coffeeIntensity, int mlOfMilk) {
        super(drinkType, coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Millimeters of milk added to the drink: " + this.mlOfMilk);
    }
}
