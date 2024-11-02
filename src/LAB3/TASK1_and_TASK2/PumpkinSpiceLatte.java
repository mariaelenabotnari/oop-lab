package LAB3.TASK1_and_TASK2;

public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(String drinkType, Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(drinkType, coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milligrams of pumpkin spice added to the drink: " + this.mgOfPumpkinSpice);
    }
}
