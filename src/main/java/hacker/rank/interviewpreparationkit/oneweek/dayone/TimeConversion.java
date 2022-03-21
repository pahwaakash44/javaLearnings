package hacker.rank.interviewpreparationkit.oneweek.dayone;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class TimeConversionResult
{
    
    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    
    public static String timeConversion(String s) {
        // Write your code here
        return LocalTime.parse(s, DateTimeFormatter.ofPattern("hh:mm:ssa")).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
    
}
public class TimeConversion
{
    public static void main(String[] args) throws IOException {
       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String s = bufferedReader.readLine();*/
        
        String result = TimeConversionResult.timeConversion("07:05:45PM");
//        String result = TimeConversionResult.timeConversion("12:00:00AM");
    
        System.out.println(result);
        
        /*bufferedWriter.write(result);
        bufferedWriter.newLine();*/
        
       /* bufferedReader.close();
        bufferedWriter.close();*/
    }
}
