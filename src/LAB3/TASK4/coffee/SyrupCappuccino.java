package LAB3.TASK4.coffee;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public enum SyrupType {
        macadamia, vanilla, coconut, caramel, chocolate, popcorn
    }

    public SyrupCappuccino(String drinkType, Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(drinkType, coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public void printCoffeeDetails () {
        super.printCoffeeDetails();
        System.out.println("The type of syrup chosen for the drink: " + this.syrup);
    }

    @Override
    public void drinkRecipe() {
        super.drinkRecipe();
        System.out.println("Add " + this.syrup + " syrup in the " + this.drinkType);
    }

    public void setSyrup(SyrupType syrup) {
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }
}

