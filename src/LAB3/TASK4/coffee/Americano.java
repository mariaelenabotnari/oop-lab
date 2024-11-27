package LAB3.TASK4.coffee;

public class Americano extends Coffee {
    private int mlOfWater;

    public void setMlOfWater (int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public Americano(String drinkType, Intensity coffeeIntensity, int mlOfWater) {
        super(drinkType, coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Millimeters of water added to the drink: " + this.mlOfWater);
    }

    @Override
    public void drinkRecipe () {
        super.drinkRecipe();
        System.out.println("Add " + this.mlOfWater + " ml of water to the " + this.drinkType);
    }
}

