package LAB3.TASK4.coffee;

public class Coffee {
    final String drinkType;
    Intensity coffeeIntensity;

    public Coffee(String drinkType, Intensity coffeeIntensity) {
        this.drinkType = drinkType;
        this.coffeeIntensity = coffeeIntensity;
    }

    public enum Intensity {
        light, normal, strong
    }

    public void printCoffeeDetails() {
        System.out.println("\nDetails about the drink:");
        System.out.println("Name of the drink: " + this.drinkType);
        System.out.println("The intensity of the drink: " + this.coffeeIntensity);
    }

    public void drinkRecipe () {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants the " + this.drinkType + " " + this.coffeeIntensity);
    }

    public void setIntensity (Intensity intensity) {
        this.coffeeIntensity = intensity;
    }

    public Intensity getIntensity() {
        return this.coffeeIntensity;
    }
}

