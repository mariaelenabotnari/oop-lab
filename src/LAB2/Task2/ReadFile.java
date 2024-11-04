package LAB2.Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    String readFileIntroString(String filePath) throws FileNotFoundException {

        File newFile = new File(filePath);

        Scanner readFile = new Scanner(newFile);

        StringBuilder text = new StringBuilder();
        while (readFile.hasNextLine()) {
            text.append(readFile.nextLine());
        }
        readFile.close();

        return text.toString();
    }
}

