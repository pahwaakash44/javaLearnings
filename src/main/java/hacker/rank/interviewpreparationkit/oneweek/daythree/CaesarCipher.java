package hacker.rank.interviewpreparationkit.oneweek.daythree;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class CaesarCipherResult
{
    
    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    
    public static String caesarCipher(String inputString, int k)
    {
        // Write your code here
    
        // have a map of alphabets, number
        List<String> alphabets = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i",
                                                     "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                                                     "u", "v", "w", "x", "y", "z");
        System.out.println(alphabets.size());
        
        char[] inputStringChar = inputString.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
    
        // iterate over string and for each letter
        for(char currentChar : inputStringChar)
        {
            int curIndex = alphabets.indexOf(String.valueOf(currentChar).toLowerCase(Locale.ROOT));
            
            // find the +k value in map
            int newIndex = curIndex + k;
            System.out.printf("current char: %c, currentIndex: %d, newIndex: %d%n", currentChar, curIndex, newIndex);
            
            // if the +k > map size start from 0
            while(newIndex >= alphabets.size())
            {
                newIndex = newIndex - alphabets.size();
                System.out.printf("newIndex: %d%n", newIndex);
            }
        
        
            // if the letter is not an alphabet then skip changing it
            //use the existing element it can be any non-alphabetical char
            // if the char is upper case then new should also be upper case
            stringBuilder.append(curIndex == -1 ? currentChar : getNewAlphabet(alphabets, newIndex, currentChar));
        }
        
        return stringBuilder.toString();
    }
    
    private static String getNewAlphabet(List<String> alphabets, int newIndex, char currentChar)
    {
        String newChar = alphabets.get(newIndex);
        if (Character.isUpperCase(currentChar))
            return newChar.toUpperCase(Locale.ROOT);
        return newChar;
    }
}

public class CaesarCipher
{
    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        String s = bufferedReader.readLine();
        
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        
        String result = CaesarCipherResult.caesarCipher(s, k);
        
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();*/
    
//        String result = CaesarCipherResult.caesarCipher("middle-Outz", 2);
//        String result = CaesarCipherResult.caesarCipher("There's-a-starman-waiting-in-the-sky", 3);
//        String result = CaesarCipherResult.caesarCipher("Hello_World!", 4);
        String result = CaesarCipherResult.caesarCipher("www.abc.xy", 87);
        System.out.println(result);
        //okffng-Qwvb
    }
}
