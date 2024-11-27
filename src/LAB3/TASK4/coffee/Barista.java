package LAB3.TASK4.coffee;

import java.util.Scanner;

public class Barista {

    public void chooseDrink() {
        // TODO refactor to only one unit of logic for coffee making
        System.out.println("\nDrink Options: ");

        System.out.println("1. Coffee");
        System.out.println("2. Cappuccino");
        System.out.println("3. Americano");
        System.out.println("4. Pumpkin Spice Latte");
        System.out.println("5. Syrup Cappuccino");
        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nChoose the drink: ");
            choice = scanner.nextInt();

            if (choice <= 0 || choice > 6) {
                System.out.println("Invalid choice. Please try again.");
            }
            switch(choice) {
                case 1:
                    MakeCoffee.makeCoffee();
                    break;
                case 2:
                    MakeCappuccino.makeCappuccino();
                    break;
                case 3:
                    MakeAmericano.makeAmericano();
                    break;
                case 4:
                    MakePumpkinSpiceLatte.makePumpkinSpiceLatte();
                    break;
                case 5:
                    MakeSyrupCappuccino.makeSyrupCappuccino();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
            }
        }
        while (choice != 6);
    }
}

