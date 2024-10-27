package LAB2.Task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class TextData extends ReadFile {

    String fileName;
    String text;
    String filePath;
    int numberOfVowels;
    int numberOfConsonants;
    int numberOfLetters;
    int numberOfSentences;
    String longestWord;

    //Getters
    public String getFilename () {
        return fileName;
    }

    public String getPath () {
        return filePath;
    }

    public String getText () {
        return text;
    }

    int getNumberOfVowels () {
        return numberOfVowels;
    }

    int getNumberOfConsonants () {
        return numberOfConsonants;
    }

    int getNumberOfLetters () {
        return numberOfLetters;
    }

    int getNumberOfSentences () {
        return numberOfSentences;
    }

    String getLongestWord () {
        return longestWord;
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Provide a file path.");
            return;
        }

        String filePath = args[0];
        File newFile = new File(filePath);
        TextData fileContent = new TextData();

        fileContent.text = fileContent.readFileIntroString(filePath);

        fileContent.fileName = newFile.getName();
        String fileName = fileContent.getFilename();
        System.out.println("File name: " + fileName);

        fileContent.filePath = newFile.getParent();
        String fileDirectory = fileContent.getPath();
        System.out.println("File Path: " + fileDirectory);

        String textFile = fileContent.getText();
        System.out.println("The text in the file: " + textFile);

        int vowelsCount = 0;
        ArrayList<String> vowels = new ArrayList<String>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");

        for (char character : textFile.toLowerCase().toCharArray()) {
            for (int i = 0; i < vowels.size(); i++) {
                if (character == vowels.get(i).charAt(0)) {
                    vowelsCount++;
                }
            }
        }
        fileContent.numberOfVowels = vowelsCount;
        System.out.println("Number of vowels: " + fileContent.getNumberOfVowels());

        int stringLength = 0;
        for (char character: textFile.toCharArray()) {
            if (Character.isLetter(character)) {
                stringLength++;
            }
        }

        int consonantsCount = stringLength - vowelsCount;
        fileContent.numberOfConsonants = consonantsCount;
        System.out.println("Number of consonants:" + " " + fileContent.getNumberOfConsonants());

        fileContent.numberOfLetters = stringLength;
        System.out.println("Number of letters:" + " " + fileContent.getNumberOfLetters());

        int sentenceCount = 0;
        for (char character: textFile.toCharArray()) {
            if (character == '.' || character == '!' || character == '?') {
                sentenceCount++;
            }
        }
        fileContent.numberOfSentences = sentenceCount;
        System.out.println("Number of sentences: " + fileContent.getNumberOfSentences());

        ArrayList<Integer> wordsLength = new ArrayList<>();
        HashMap<String, Integer> dictionary = new HashMap<>();
        String[] words = textFile.split("[\\s\\p{Punct}]+");
        for (String word: words) {
            int sizeWord = word.length();
            dictionary.put(word, sizeWord);
            wordsLength.add(sizeWord);
        }

        int max = dictionary.get(words[0]);
        String longestWord = words[-0];
        for (String key : dictionary.keySet()) {
            if (max < dictionary.get(key)) {
                max = dictionary.get(key);
                longestWord = key;
            }
        }

        fileContent.longestWord = longestWord;
        System.out.println("The longest word: " + fileContent.getLongestWord() + "." + " It has " + max + " characters");
    }
}

