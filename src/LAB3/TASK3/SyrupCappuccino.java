package LAB3.TASK3;

public class SyrupCappuccino extends Coffee {
    private int mlOfMilk;
    private SyrupType syrup;

    public enum SyrupType {
        macadamia, vanilla, coconut, caramel, chocolate, popcorn
    }

    public SyrupCappuccino(String drinkType, Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(drinkType, coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        this.syrup = syrup;
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public void drinkRecipeSyrupCappuccino () {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants a " + this.drinkType + " with " + this.getIntensity() + " intensity. Add " + this.getMlOfMilk() + " ml of milk and " + this.getSyrup() + " syrup.");
    }
}
