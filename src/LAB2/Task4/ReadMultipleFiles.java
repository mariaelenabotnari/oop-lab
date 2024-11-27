package LAB2.Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadMultipleFiles {
    public static void main(String[] args) throws FileNotFoundException {

        File newFile;
        Scanner readFile;
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            newFile = new File(args[i]);
            readFile = new Scanner(newFile);
            text.setLength(0);
            while (readFile.hasNextLine()) {
                text.append(readFile.nextLine());
            }
            readFile.close();
            System.out.println("Text from file " + (i + 1) + ": " + text);
        }
    }
}
