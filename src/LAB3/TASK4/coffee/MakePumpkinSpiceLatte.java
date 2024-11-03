package LAB3.TASK4.coffee;

import java.util.Scanner;

public class MakePumpkinSpiceLatte {
    public static void makePumpkinSpiceLatte() {

        PumpkinSpiceLatte coffeeOrder = new PumpkinSpiceLatte("pumpkin spice latte", Coffee.Intensity.normal, 110, 35);

        Scanner scanner = new Scanner(System.in);
        int chosenIntensity;

        do {
            Coffee.Intensity[] intensities = Coffee.Intensity.values();
            System.out.println("\nIntensities the pumpkin spice latte could have: ");
            for (int i = 0; i < intensities.length; i++) {
                System.out.println((i + 1) + ". " + intensities[i]);
            }
            System.out.println("Choose the intensity: ");
            chosenIntensity = scanner.nextInt();

            if (chosenIntensity <= 0 || chosenIntensity > 4) {
                System.out.println("Invalid choice. Try again.");
            }
            else {
                coffeeOrder.setIntensity(intensities[chosenIntensity - 1]);
                break;
            }
        }
        while (true);

        System.out.println("Choose the amount of milk: ");
        int chooseMlMilk = scanner.nextInt();
        coffeeOrder.setMlOfMilk(chooseMlMilk);

        System.out.println("Choose the amount of pumpkin spice: ");
        int chosenPumpkinSpice = scanner.nextInt();
        coffeeOrder.setMgOfPumpkinSpice(chosenPumpkinSpice);

        System.out.println("\nOrder complete. Final order: ");
        System.out.println("The customer chose " + coffeeOrder.drinkType + " with the intensity " + coffeeOrder.getIntensity() + ", " + coffeeOrder.getMlOfMilk() + " ml of milk and " + coffeeOrder.getMgOfPumpkinSpice() + " mg of pumpkin spice.");
    }
}

