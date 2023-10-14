package utils;

import java.security.SecureRandom;

public class PasswordGenerator {
    public static final String englishAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generateRandomPassword(Integer length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(englishAlphabet.charAt(random.nextInt(englishAlphabet.length())));
            password.append(random.nextInt(10));
        }
        return password.toString();
    }
}
