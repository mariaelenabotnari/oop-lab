package LAB3.TASK1_and_TASK2;

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
}
