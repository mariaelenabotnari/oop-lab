package LAB3.TASK4.coffee;

import java.util.Scanner;

public class MakeSyrupCappuccino {
    public static void makeSyrupCappuccino() {
        SyrupCappuccino coffeeOrder = new SyrupCappuccino("syrup cappuccino", Coffee.Intensity.normal, 120, SyrupCappuccino.SyrupType.macadamia);
        Scanner scanner = new Scanner(System.in);

        int choiceIntensity;

        do {
            Coffee.Intensity[] intensities = Coffee.Intensity.values();
            System.out.println("Intensities the syrup cappuccino could have:");
            for (int i = 0; i < intensities.length; i++) {
                System.out.println((i + 1) + ". " + intensities[i]);
            }
            System.out.println("Choose the intensity: ");
            choiceIntensity = scanner.nextInt();

            if (choiceIntensity <= 0 || choiceIntensity >= 4) {
                System.out.println("Invalid choice. Try again.");
            } else {
                coffeeOrder.setIntensity(intensities[choiceIntensity - 1]);
                break;
            }
        } while (true);

        System.out.println("Choose the amount of milk: ");
        int chooseMlMilk = scanner.nextInt();
        coffeeOrder.setMlOfMilk(chooseMlMilk);

        int choiceSyrup;

        do {
            SyrupCappuccino.SyrupType[] syrups = SyrupCappuccino.SyrupType.values();

            System.out.println("Syrups available: ");
            for (int i = 0; i < syrups.length; i++) {
                System.out.println((i + 1) + ". " + syrups[i]);
            }
            System.out.println("Choose the syrup type: ");
            choiceSyrup = scanner.nextInt();

            if (choiceSyrup <= 0 || choiceSyrup >= 7) {
                System.out.println("Invalid choice. Try again.");
            }
            else {
                coffeeOrder.setSyrup(syrups[choiceSyrup - 1]);
                break;
            }
        } while (true);

        System.out.println("\nOrder complete. Final order: ");
        System.out.println("The customer chose " + coffeeOrder.drinkType + " with the intensity " + coffeeOrder.getIntensity() + ", " + coffeeOrder.getMlOfMilk() + " ml of milk" + " and " + coffeeOrder.getSyrup() + " syrup.");
    }
}

