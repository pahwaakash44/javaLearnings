package hacker.rank.interviewpreparationkit.oneweek.dayfour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveDigitSum
{
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        String n = firstMultipleInput[0];
        
        int k = Integer.parseInt(firstMultipleInput[1]);
        
        int result = Result.superDigit(n, k);
        
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        
        bufferedReader.close();
        bufferedWriter.close();*/
    
        System.out.println("final: " + Result.superDigit("9875", 4));
        System.out.println("final: " + Result.superDigit(
                "7404954009694227446246375747227852213692570890717884174001587537145838723390362624487926131161112710589127423098959327020544003395792482625191721603328307774998124389641069884634086849138515079220750462317357487762780480576640689175346956135668451835480490089962406773267569650663927778867764315211280625033388271518264961090111547480467065229843613873499846390257375933040086863430523668050046930387013897062106309406874425001127890574986610018093859693455518413268914361859000614904461902442822577552997680098389183082654625098817411306985010658756762152160904278169491634807464356130877526392725432086439934006728914411061861235300979536190100734360684054557448454640750198466877185875290011114667186730452681943043971812380628117527172389889545776779555664826488520325234792648448625225364535053605515386730925070072896004645416713682004600636574389040662827182696337187610904694029221880801372864040345567230941110986028568372710970460116491983700312243090679537497139499778923997433720159174153", 100000));
    }
}

class Result
{
    
    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */
    
/*    public static int superDigit(String n, int k) {
        // Write your code here
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < k; i++)
        {
            stringBuilder.append(n);
        }
//        System.out.println(stringBuilder.toString());
        return superDigit(stringBuilder.toString());
    }*/
    
    public static int superDigit(String n, int k)
    {
        // Write your code here
        if (n.length() == 1)
            return Character.getNumericValue(n.charAt(0));
        else
        {
            long sum = 0;
            for (int i = 0; i < n.length(); i++)
            {
                sum = sum + Character.getNumericValue(n.charAt(i));
            }
            return superDigit(String.valueOf(sum * k), 1);
        }
    }
}