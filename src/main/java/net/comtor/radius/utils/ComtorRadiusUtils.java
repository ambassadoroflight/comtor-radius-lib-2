package net.comtor.radius.utils;

import java.util.Random;

/**
 *
 * @author juandiego@comtor.net
 * @since Jan 29, 2019
 */
public final class ComtorRadiusUtils {

    private ComtorRadiusUtils() {
        
    }
    
    public static String generatePin(int groups, int size) {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        StringBuilder pin = new StringBuilder();

        for (int i = 0; i < groups; i++) {
            for (int j = 0; j < size; j++) {
                int a = random.nextInt(26) + 65;
                pin.append((char) a);
            }

            if ((i + 1) < groups) {
                pin.append('-');
            }
        }

        return pin.toString();
    }

}
