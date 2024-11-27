package LAB4.TASK4_TASK5;

import LAB4.TASK1.Car;
import LAB4.TASK2.CarsCount;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    public static void main(String[] args) {

        Queue<Car> queueCars = new ConcurrentLinkedQueue<>();

        String jsonFolderPath = "C:\\\\Users\\\\maria\\\\IdeaProjects\\\\OOP\\\\queue";

        CarsCount count = new CarsCount();

        try {
            ReadJson.readJsonData(jsonFolderPath, queueCars, count);

            System.out.println("\nNo more cars in line.");
            System.out.println("Electric cars processed: " + count.getNrElectricCars());
            System.out.println("Gas cars processed: " + count.getNrGasCars());
            System.out.println("Cars with people: " + count.getNrCarsWithPeople());
            System.out.println("Cars with robots: " + count.getNrCarsWithRobots());
            System.out.println("Cars dined: " + count.getNrCarsDined());
            System.out.println("Cars not dined: " + count.getNrCarsNotDined());
            System.out.println("Electric cars consumption: " + count.getConsumptionElectricCars());
            System.out.println("Gas cars consumption: " + count.getConsumptionGasCars());
        } catch (Exception e) {
            System.err.println("Error in processing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
