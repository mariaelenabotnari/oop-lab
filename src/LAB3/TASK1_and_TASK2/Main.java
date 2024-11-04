package LAB3.TASK1_and_TASK2;

public class Main {
    public static void main(String[] args) {

        //Task 2

        Coffee coffee = new Coffee("Coffee", Coffee.Intensity.normal);
        coffee.printCoffeeDetails();

        Cappuccino cappuccino = new Cappuccino("Cappuccino", Cappuccino.Intensity.light, 50);
        cappuccino.printCoffeeDetails();

        Americano americano = new Americano("Americano", Americano.Intensity.strong, 100);
        americano.printCoffeeDetails();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte("Pumpkin Spice Latte", PumpkinSpiceLatte.Intensity.light, 50, 20);
        pumpkinSpiceLatte.printCoffeeDetails();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino("Syrup Cappuccino", SyrupCappuccino.Intensity.strong, 110, SyrupCappuccino.SyrupType.caramel);
        syrupCappuccino.printCoffeeDetails();
    }
}
