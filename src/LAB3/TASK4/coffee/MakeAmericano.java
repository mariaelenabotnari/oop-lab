package LAB3.TASK4.coffee;

import java.util.Scanner;

public class MakeAmericano {
    public static void makeAmericano() {
        Americano coffeeOrder = new Americano("americano", Coffee.Intensity.normal, 80);
        Scanner scanner = new Scanner(System.in);
        int chosenIntensity;

        do {
            System.out.println("\nIntensities the americano could have:");
            Coffee.Intensity[] intensities = Coffee.Intensity.values();
            for (int i = 0; i < intensities.length; i++) {
                System.out.println((i + 1) + ". " + intensities[i]);
            }

            System.out.println("Choose the intensity: ");
            chosenIntensity = scanner.nextInt();

            if (chosenIntensity < 1 || chosenIntensity >= 4) {
                System.out.println("Invalid choice. Please try again.");
            } else {
                coffeeOrder.setIntensity(intensities[chosenIntensity - 1]);
                break;
            }

        } while (true);

        System.out.println("Choose the amount of water: ");
        int chosenMlWater = scanner.nextInt();
        coffeeOrder.setMlOfWater(chosenMlWater);

        System.out.println("\nOrder complete. Final order: ");
        System.out.println("The customer chose " + coffeeOrder.drinkType + " with the intensity " + coffeeOrder.getIntensity() + " and " + coffeeOrder.getMlOfWater() + " ml of water.");

    }
}

