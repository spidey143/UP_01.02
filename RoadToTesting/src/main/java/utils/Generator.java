package utils;

import java.security.SecureRandom;
import java.util.Random;

public class Generator {
    public static final String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static Random random = new Random();

    public static String generateRandomString(Integer length) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < length; i++)
            resultStr.append(russianAlphabet.charAt(random.nextInt(russianAlphabet.length())));
        return resultStr.toString();
    }

    public static String generateRandomPassword(Integer length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(englishAlphabet.charAt(random.nextInt(englishAlphabet.length())));
            password.append(random.nextInt(10));
        }
        return password.toString();
    }

    public static String generateRandomPhone() {
        StringBuilder phone = new StringBuilder("+7(");
        for (int i = 0; i < 6; i++) {
            phone.append(new Random().nextInt(10));
            if (i == 2) phone.append(")");
        }
        phone.append("-");
        for (int i = 0; i < 4; i++) {
            phone.append(new Random().nextInt(10));
            if (i == 1) phone.append("-");
        }
        return phone.toString();
    }
}
