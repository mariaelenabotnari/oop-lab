package LAB3.TASK3;

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

    public void setIntensity (Intensity intensity) {
        this.coffeeIntensity = intensity;
    }

    public Intensity getIntensity() {
        return this.coffeeIntensity;
    }

    public void drinkRecipeCoffee() {
        System.out.println("\nRecipe for " + this.drinkType);
        System.out.println("The customer wants the " + this.drinkType + " " + this.coffeeIntensity + ".");
    }
}
