package tests.utils;

import framework.logger.Logger;

import java.util.Random;

public class RandomUtils {
    private final static int ASCII_FIRST_LETTER_LATIN_ALPHABET = 97;
    private final static int LATIN_ALPHABET = 26;

    public static String randomText(int lengthWord){
        Logger.getLogger().info("Random text, length word "+lengthWord);
        StringBuilder word = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < lengthWord; i++){
            word.append((char) (rand.nextInt(LATIN_ALPHABET) + ASCII_FIRST_LETTER_LATIN_ALPHABET));
        }
        return word.toString();
    }
}
