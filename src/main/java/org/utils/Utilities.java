package org.utils;

import java.util.Random;

public class Utilities {

    public static String getRandomString(int tamanio) {
        Random r = new Random();
        StringBuilder randomText = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < tamanio; i++) {
            randomText.append(alphabet.charAt(r.nextInt(alphabet.length())));

        }
        return randomText.toString();
    }
}
