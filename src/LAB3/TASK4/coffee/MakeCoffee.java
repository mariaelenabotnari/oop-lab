package LAB3.TASK4.coffee;

import java.util.Scanner;

class MakeCoffee {

    public static void makeCoffee() {
        Coffee coffeeOrder = new Coffee("coffee", Coffee.Intensity.normal);

        Scanner scanner = new Scanner(System.in);
        int chosenIntensity;

        do {
            System.out.println("\nIntensities the coffee could have:");
            Coffee.Intensity[] intensities = Coffee.Intensity.values();
            for (int i = 0; i < intensities.length; i++) {
                System.out.println((i + 1) + ". " + intensities[i]);
            }

            System.out.println("Choose the intensity: ");
            chosenIntensity = scanner.nextInt();

            if (chosenIntensity <= 0 || chosenIntensity >= 4) {
                System.out.println("Invalid choice. Please try again.");
            } else {
                coffeeOrder.setIntensity(intensities[chosenIntensity - 1]);
                break;
            }

        } while (true);

        System.out.println("\nOrder complete. Final order:");
        System.out.println("The customer chose " + coffeeOrder.drinkType + " with the intensity " + coffeeOrder.getIntensity() + ".");
    }
}

