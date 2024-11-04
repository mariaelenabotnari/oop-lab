package LAB3.TASK4.coffee;

import java.util.Scanner;

public class MakeCappuccino {
    public static void makeCappuccino() {
        Cappuccino coffeeOrder = new Cappuccino("cappuccino", Coffee.Intensity.normal, 100);
        Scanner scanner = new Scanner(System.in);
        int chosenIntensity;

        do {
            System.out.println("\nIntensities the cappuccino could have:");
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

        System.out.println("Choose the amount of milk: ");
        int chooseMlMilk = scanner.nextInt();
        coffeeOrder.setMlOfMilk(chooseMlMilk);

        System.out.println("\nOrder complete. Final order: ");
        System.out.println("The customer chose " + coffeeOrder.drinkType + " with the intensity " + coffeeOrder.getIntensity() + " and " + coffeeOrder.getMlOfMilk() + " ml of milk.");
    }
}

