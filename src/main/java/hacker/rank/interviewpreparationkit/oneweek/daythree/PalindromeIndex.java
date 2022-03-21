package hacker.rank.interviewpreparationkit.oneweek.daythree;

class PalindromeIndexResult {
    
    /*
     * Complete the 'palindromeIndex' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    
    public static int palindromeIndex1(String inputString)
    {
        // Write your code here
        
        
        // check if string is not null/empty then return -1
        if (null == inputString || inputString.isEmpty())
            return -1;
    
        // check if the string is palindrome then return -1
        if (isPalindrome(inputString))
            return -1;
    
        // iterate over all the elements, remove each and check if string is palindrome
        // if palindrome then return the index of char
        char[] charArray = inputString.toCharArray();
        
        for (int i = 0; i < charArray.length; i++)
        {
            if(isPalindrome(new StringBuilder(inputString).deleteCharAt(i).toString()))
                return i;
        }
    
        // if all elements are iterated over then return -1
        return -1;
    }
    
    private static boolean isPalindrome(String inputString)
    {
        return new StringBuilder(inputString).reverse().toString().equalsIgnoreCase(inputString);
    }
    
    
    public static int palindromeIndex2(String inputString)
    {
        // Write your code here
        char[] inputChar = inputString.toCharArray();
        int j = inputChar.length - 1;
    
        for (int i = 0; i < inputChar.length; i++)
        {
            System.out.printf("%d=%c \t", i, inputChar[i]);
        }
    
        System.out.println();
        
        for (int i = 0; i < inputChar.length && j >= 0; i++, j--)
        {
            if (inputChar[i] != inputChar[j])
            {
                if (inputChar[i+1] == inputChar[j])
                    return i;
                else if (inputChar[i] == inputChar[j-1])
                    return j;
            }
        }
        return -1;
    }
    
    
    public static int palindromeIndex(String inputString)
    {
        // Write your code here
        int j = inputString.length() - 1;
        
        for (int i = 0; i < inputString.length(); i++)
        {
            System.out.printf("%d=%c \t", i, inputString.charAt(i));
        }
        
        System.out.println();
        
        for (int i = 0; i < inputString.length() && j >= 0; i++, j--)
        {
            if (inputString.charAt(i) != inputString.charAt(j))
            {
                if (inputString.charAt(i+1) == inputString.charAt(j))
                    return i;
                else if (inputString.charAt(i) == inputString.charAt(j-1))
                    return j;
            }
        }
        return -1;
    }
}

public class PalindromeIndex
{
    public static void main(String[] args)
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, q).forEach(qItr -> {
            try
            {
                String s = bufferedReader.readLine();
                
                int result = Result.palindromeIndex(s);
                
                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            }
            catch(IOException ex)
            {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
        bufferedWriter.close();*/
        
        /*System.out.println(PalindromeIndexResult.palindromeIndex("aaab"));
        System.out.println(PalindromeIndexResult.palindromeIndex("baa"));
        System.out.println(PalindromeIndexResult.palindromeIndex("aaa"));
        System.out.println(PalindromeIndexResult.palindromeIndex("bcbc"));*/
    
        /*
        System.out.println(PalindromeIndexResult.palindromeIndex("quyjjdcgsvvsgcdjjyq"));
        System.out.println(PalindromeIndexResult.palindromeIndex("fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf"));
        System.out.println(PalindromeIndexResult.palindromeIndex("bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb"));
        System.out.println(PalindromeIndexResult.palindromeIndex("fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf"));
        System.out.println(PalindromeIndexResult.palindromeIndex("mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm"));
        System.out.println(PalindromeIndexResult.palindromeIndex("tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt"));
        System.out.println(PalindromeIndexResult.palindromeIndex("lhrxvssvxrhl"));
        System.out.println(PalindromeIndexResult.palindromeIndex("prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp"));
        System.out.println(PalindromeIndexResult.palindromeIndex("kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk"));*/
    
        String s1 = "hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh";
        String s2 = "hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh";
    
        System.out.println("are equal : " + s1.equalsIgnoreCase(s2));
        
        System.out.println(PalindromeIndexResult.palindromeIndex(s1));
        System.out.println(PalindromeIndexResult.palindromeIndex(s2));
    }
}
