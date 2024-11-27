package LAB3.TASK1_and_TASK2;

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
}
