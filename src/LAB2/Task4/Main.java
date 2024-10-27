package LAB2.Task4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("\nTask 4: ");

        String[] dataArg1 = {"C:\\Users\\maria\\IdeaProjects\\OOP\\src\\LAB2\\Task2\\data.txt"};
        String[] dataArg2 = {"C:\\Users\\maria\\IdeaProjects\\OOP\\src\\LAB2\\Task4\\data2.txt"};
        String[] dataArg3 = {"C:\\Users\\maria\\IdeaProjects\\OOP\\src\\LAB2\\Task4\\data3.txt"};
        String[] dataArg4 = {"C:\\Users\\maria\\IdeaProjects\\OOP\\src\\LAB2\\Task4\\data4.txt"};
        ArrayList<String> dataArgsArray = new ArrayList<>();
        dataArgsArray.add(dataArg1[0]);
        dataArgsArray.add(dataArg2[0]);
        dataArgsArray.add(dataArg3[0]);
        dataArgsArray.add(dataArg4[0]);

        ReadMultipleFiles.main(dataArgsArray);
    }
}
