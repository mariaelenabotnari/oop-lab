package LAB3.TASK3;

public class Cappuccino extends Coffee {
    private int mlOfMilk;

    public Cappuccino(String drinkType, Intensity coffeeIntensity, int mlOfMilk) {
        super(drinkType, coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void drinkRecipeCappuccino() {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants a " + this.drinkType + " with " + this.getIntensity() + " intensity. Add " + this.mlOfMilk + " ml of milk to the " + this.drinkType + ".");
    }
}
