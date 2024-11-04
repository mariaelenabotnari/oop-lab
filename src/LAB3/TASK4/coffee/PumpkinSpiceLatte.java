package LAB3.TASK4.coffee;

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

    @Override
    public void drinkRecipe() {
        super.drinkRecipe();
        System.out.println("Add " + this.mgOfPumpkinSpice + " milligrams of pumpkin spice " + this.drinkType);
    }

    public void setMgOfPumpkinSpice (int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice () {
        return this.mgOfPumpkinSpice;
    }
}

