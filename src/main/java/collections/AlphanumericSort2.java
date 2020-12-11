package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AlphanumericSort2 {

    public static void main(String[] args) {
        ArrayList<String> mobileSupportedPlatforms = new ArrayList<>(Arrays.asList("Android-5.0", "Android-5.1", "Android-4.4", "Android-5.0", "Android-6.0", "Android-7.0", "Android-7.1", "Android-8.0", "Android-8.1"));

        mobileSupportedPlatforms.sort((firstString, secondString) ->
        {
            if (secondString == null || firstString == null) {
                return 0;
            }

            return Float.compare(Float.parseFloat(secondString.substring(firstString.indexOf("-") + 1)), Float.parseFloat(firstString.substring(firstString.indexOf("-") + 1)));
        });

//        Arrays.sort(mobileSupportedPlatforms, c);

//        for (int i = 0; i < mobileSupportedPlatforms.length; i++) {
//            System.out.println(mobileSupportedPlatforms[i]);
//        }

        mobileSupportedPlatforms.stream().forEach(System.out::println);
    }

    int compareRight(String a, String b) {
        int bias = 0, ia = 0, ib = 0;

        // The longest run of digits wins. That aside, the greatest
        // value wins, but we can't know that it will until we've scanned
        // both numbers to know that they have the same magnitude, so we
        // remember it in BIAS.
        for (; ; ia++, ib++) {
            char ca = charAt(a, ia);
            char cb = charAt(b, ib);

            if (!Character.isDigit(ca) && !Character.isDigit(cb)) {
                return bias;
            }
            if (!Character.isDigit(ca)) {
                return -1;
            }
            if (!Character.isDigit(cb)) {
                return +1;
            }
            if (ca == 0 && cb == 0) {
                return bias;
            }

            if (bias == 0) {
                if (ca < cb) {
                    bias = -1;
                } else if (ca > cb) {
                    bias = +1;
                }
            }
        }
    }

    static char charAt(String s, int i) {
        return i >= s.length() ? 0 : s.charAt(i);
    }
}
