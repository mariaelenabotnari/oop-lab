package LAB2.Task2;

import java.io.File;
import java.io.FileNotFoundException;

public class TextData extends ReadFile {

    private String fileName;
    private String text;
    private String filePath;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String textFile) throws FileNotFoundException {
        this.text = readFileIntroString(textFile);
        this.fileName = new File(textFile).getName();
        this.filePath = new File(textFile).getParent();
        this.numberOfVowels = calculateVowels(text);
        this.numberOfLetters = calculateLetters(text);
        this.numberOfConsonants = calculateConsonants();
        this.numberOfSentences = calculateSentences(text);
        this.longestWord = findLongestWord(text);
    }

    // Getters
    public String getFilename() {
        return fileName;
    }

    public String getPath() {
        return filePath;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    private int calculateVowels(String text) {
        int vowelsCount = 0;
        String vowels = "aeiou";
        for (char character : text.toLowerCase().toCharArray()) {
            if (vowels.indexOf(character) != -1) {
                vowelsCount++;
            }
        }
        return vowelsCount;
    }

    private int calculateLetters(String text) {
        int letterCount = 0;
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                letterCount++;
            }
        }
        return letterCount;
    }

    private int calculateConsonants() {
        return numberOfLetters - numberOfVowels;
    }

    private int calculateSentences(String text) {
        int sentenceCount = 0;
        for (char character : text.toCharArray()) {
            if (character == '.' || character == '!' || character == '?') {
                sentenceCount++;
            }
        }
        return sentenceCount;
    }

    private String findLongestWord(String text) {
        String longestWord = "";
        for (String word : text.split("[\\s\\p{Punct}]+")) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Provide a file path.");
        }
    }
}
