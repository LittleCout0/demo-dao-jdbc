package utils;

import java.util.Random;

public class Util {

    public static String generateRandomString() {
        int leftLimit = 97; // letter a
        int righLimit = 122; //letter z
        int targetLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, righLimit + 1)
                .limit(targetLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
