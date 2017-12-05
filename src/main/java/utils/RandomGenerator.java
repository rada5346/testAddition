package utils;

import java.util.Random;

public class RandomGenerator {
    private final static Random random = new Random();

    public static String randStr(int length){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghiklmnopqrstuvwxy";
        char[] symbols = new char[length];
        for(int i = 0; i< length; i++){
            symbols[i] = letters.toCharArray()[random.nextInt(length)];
        }
        return new String(symbols);
    }

    public static int generateInt(int maxExpectedValue){
        return random.nextInt(maxExpectedValue);
    }
}
