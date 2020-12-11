package collections;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphanumericSort1 {

    public static void main(String[] args) {
        final Pattern p = Pattern.compile("^\\d+");
        String[] examples = {
                "Android-4.4", "Android-5.0", "Android-5.1", "Android-6.0", "Android-7.0", "Android-7.1", "Android-8.0", "Android-8.1"
//                "1some", "2some", "20some", "21some", "3some", "some", "1abc", "abc"
        };
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String object1, String object2) {
                Matcher m = p.matcher(object1);
                Integer number1 = null;
                if (!m.find()) {
                    return object1.compareTo(object2);
                } else {
                    Integer number2 = null;
                    number1 = Integer.parseInt(m.group());
                    m = p.matcher(object2);
                    if (!m.find()) {
                        return object1.compareTo(object2);
                    } else {
                        number2 = Integer.parseInt(m.group());
                        int comparison = number1.compareTo(number2);
                        if (comparison != 0) {
                            return comparison;
                        } else {
                            return object1.compareTo(object2);
                        }
                    }
                }
            }
        };
        List<String> examplesList = new ArrayList<String>(Arrays.asList(examples));
        Collections.sort(examplesList, c);
        System.out.println(examplesList);
    }
}