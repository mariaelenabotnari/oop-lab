package LAB3.TASK3;

public class Americano extends Coffee {
    private int mlOfWater;

    public Americano(String drinkType, Intensity coffeeIntensity, int mlOfWater) {
        super(drinkType, coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    public void setMlOfWater (int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void drinkRecipeAmericano () {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants an " + this.drinkType + " with " + this.getIntensity() + " intensity. Add " + this.mlOfWater + " ml of water to the " + this.drinkType + ".");
    }
}
