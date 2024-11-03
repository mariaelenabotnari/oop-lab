package LAB3.TASK4.coffee;

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

    @Override
    public void drinkRecipe() {
        super.drinkRecipe();
        System.out.println("Add " + this.mlOfMilk + " millimeters to the " + this.drinkType);
    }

    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
}

