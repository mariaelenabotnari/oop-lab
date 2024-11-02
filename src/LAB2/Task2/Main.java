package LAB2.Task2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("No file path provided as an argument.");
            return;
        }

        String dataArg = args[0];
        System.out.println("\nTask 2: ");

        TextData fileContent = new TextData(dataArg);

        System.out.println("File name: " + fileContent.getFilename());
        System.out.println("File Path: " + fileContent.getPath());
        System.out.println("The text in the file: " + fileContent.getText());
        System.out.println("Number of vowels: " + fileContent.getNumberOfVowels());
        System.out.println("Number of consonants: " + fileContent.getNumberOfConsonants());
        System.out.println("Number of letters: " + fileContent.getNumberOfLetters());
        System.out.println("Number of sentences: " + fileContent.getNumberOfSentences());
        System.out.println("The longest word: " + fileContent.getLongestWord() + ".");
    }
}
