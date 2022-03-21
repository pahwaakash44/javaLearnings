package hacker.rank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class FindDay
{
    public static void main(String[] args)
    {
        int month = 8;
        int day = 5;
        int year = 2015;
        
        String dateString = day + "-" + month + "-" + year;
        System.out.println(dateString);
        String dayOfWeek = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("d-m-yyyy")).
                getDayOfWeek().
                getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH);
    
        System.out.println(dayOfWeek);
    }
}
