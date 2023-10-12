package utils;

import java.util.Random;

public class StringGenerator {
    public static final String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    //public static final String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static Random random = new Random();

    public static String randomString(Integer length) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < length; i++)
            resultStr.append(russianAlphabet.charAt(random.nextInt(russianAlphabet.length())));
        return resultStr.toString();
    }
}
