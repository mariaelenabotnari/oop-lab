package LAB3.TASK3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Task 3

        Coffee drinkOrder1 = new Coffee("Coffee", Coffee.Intensity.strong);

        Coffee drinkOrder2 = new Americano("Americano", Americano.Intensity.light, 111);

        Coffee drinkOrder3 = new Cappuccino("Cappuccino", Coffee.Intensity.normal, 130);

        Coffee drinkOrder4 = new PumpkinSpiceLatte("Pumpkin Spice Latte", PumpkinSpiceLatte.Intensity.strong, 150, 28);

        Coffee drinkOrder5 = new SyrupCappuccino("Syrup Cappuccino", SyrupCappuccino.Intensity.normal, 120, SyrupCappuccino.SyrupType.coconut);

        List<Coffee> drinkOrders  = new ArrayList<>();
        drinkOrders.add(drinkOrder1);
        drinkOrders.add(drinkOrder2);
        drinkOrders.add(drinkOrder3);
        drinkOrders.add(drinkOrder4);
        drinkOrders.add(drinkOrder5);

        for (Coffee drink : drinkOrders) {
            if (drink instanceof Americano) {
                Americano americano = (Americano) drink;
                americano.drinkRecipeAmericano();
            }
            else if (drink instanceof Cappuccino) {
                Cappuccino cappuccino = (Cappuccino) drink;
                cappuccino.drinkRecipeCappuccino();
            }
            else if (drink instanceof PumpkinSpiceLatte) {
                PumpkinSpiceLatte pumpkinspicelatte = (PumpkinSpiceLatte) drink;
                pumpkinspicelatte.drinkRecipePumpkinSpiceLatte();
            }
            else if (drink instanceof SyrupCappuccino) {
                SyrupCappuccino syrupcappuccino = (SyrupCappuccino) drink;
                syrupcappuccino.drinkRecipeSyrupCappuccino();
            }
            else {
                drink.drinkRecipeCoffee();
            }
        }
    }
}
