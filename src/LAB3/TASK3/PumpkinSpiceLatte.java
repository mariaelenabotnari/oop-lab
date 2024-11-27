package LAB3.TASK3;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;

    public PumpkinSpiceLatte(String drinkType, Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(drinkType, coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setMgOfPumpkinSpice (int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice () {
        return this.mgOfPumpkinSpice;
    }

    public void drinkRecipePumpkinSpiceLatte () {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants a " + this.drinkType + " with " + this.getIntensity() + " intensity. Add " + this.getMlOfMilk() + " ml of milk and " + this.getMgOfPumpkinSpice() + " mg of pumpkin spice.");
    }
}
