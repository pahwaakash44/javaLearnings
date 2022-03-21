package hacker.rank.interviewpreparationkit.oneweek.dayfour;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GridChallenge
{
    public static void main(String[] args) throws IOException
    {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                
                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());
                
                String result = GridChallengeResult.gridChallenge(grid);
                
                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        bufferedReader.close();
        bufferedWriter.close();*/
        testCase(Arrays.asList("abc", "lmp", "qrt"));
        testCase(Arrays.asList("mpxz", "abcd", "wlmf"));
        testCase(Arrays.asList("abc", "hjk", "mpq", "rtv"));
        testCase(Arrays.asList("eabcd", "fghij", "olkmn", "trpqs", "xywuv"));
        testCase(Arrays.asList("lnpxeemwlqlzpxrmrmwbseqfnpkzaafdnukixaopcfvhqw",
                "dhfhhoyhhzleldljmirjbqagcleivzomlpanqzsmqnrzij",
                "zcsrvgqlmrgknqhwtcqzyldjanlczysnspvusziqtazjlu",
                "idiknfqdygrwhvdzperlvgueqhuezsrwzztlodqgipnqzb",
                "zjfyxbghvdecpzhvoxzojcpciaspyoeaetimmoccjqxtmv",
                "mxwnhdyjutecwbrxdjmrbdjvbzprgnekvnvhxnuvekoflo",
                "jjbjxzuaafatzdwlnzcorkiagrwzvrmjqqbdlmgyewzsea",
                "bmvyqojhnbfrypiiwvtgifmqqdcuilohbfvkqjhlcwsfyo",
                "zrbjhsrxnllmsdfqurkjfomwsvgfepwttohojxmrhexpmy",
                "hcdxtucpeptgqhckpdxdcgpvhkiuucvwbuhtmbskqdlasw",
                "rtocxkyrsrbluwvpfkekqkdwncvozfgmcrswpksiqmfnnl",
                "xawlpinqjstxvrqvsugbvszhibbcmbdwktgwjlezakyqrr",
                "cfghwolkahdafrcuufklziipmtkhuxdrxqlavcrxavxuas",
                "plcsutiemkgfunhpyeiuvxwjppzsopglcyhgidsyhjnutp",
                "vyyrbmfyfwpcowlpytmkvsyrzgiausrulsxtwysjgpgtqi",
                "bsoknggdytplubxzjczatotnpovriwibeamjfnyxibvama",
                "imkshtavbjpnkafuxwbzpiqlnnotrxmjepzeuwtuewtqab",
                "ttjzqrcdcofkljaevmauexsxlkrxuanxgrsmsrxckixpoz",
                "aocndkatjggduuyiksgmovthyoomrfsaxlnjouszxxoqtc",
                "ahmkgizkvsbrqyricbtnpvpnibvgvnnrnqphkstvcjsbli",
                "biasqbcofwdgabnipodjkriiyqlhaddpegkmydutcyoksk",
                "avyaodwtgbdsnhheoearlinfcadeteiiudobbvqdqizcry",
                "mhdekyvubghealrenyshjcjuhxxzimsgvukcdfdbjramzq",
                "ayrzjanrebdgowsngullkgyvlgqzjexebleigxvgwjnbyf",
                "vcpnclkhoawabjlhfnrncxfswjjmpxqcwoeqpyaitwdrjf",
                "ghngenuvshwuaubahlzazwmgnsmtzyqfvvoxnhiufhxpac",
                "ljrwslmgjilvdommuvpebcznjalxuazyujtzpewdbxjnwj",
                "jqirnjnheowbioheyleyhkrcyfxuweyipumfojetmvomuz",
                "vnnlsozyplofqkxfwcmlyntfrhspvbscocodlejqrymdeu",
                "lgjcimksyragrhhagkmlnaysfxzswxfkhqzrhjlgkemmhp",
                "weoxhopddcyiiikwblqvvcxcuxkebhywdacpmjrlkosxmw",
                "bwcxxsytqdpybjxyqgmggitkgpkiytnwprsnxrygryxigo",
                "qtwyleqxqflmaudekmdmgscfvjfwkchacxmokxrcfgwnhl",
                "dgcmvhgnzigmrxougsbhwdhugyvloaqlliybbzkttmolln",
                "jqmrfoyhwxbiyvzntvxozfswwjbeybahggfjrrzzhbapyi",
                "oxbjadgrttqnfbevqolflhdpmgwgudhwfeebauqhhygvnt",
                "kwmqirrljycddqcvjanibiarpcjjqiuvkdbdyzogbcixah",
                "yyykebcfsnixcjdbkxtqvqynafmtuvoepeayiaqinvmjen",
                "lsyxwgpfxlfkxckzsjzonxkhullkatmnwwfuicgjzbnvzf",
                "vihglfapunknuitwtcxzdwjyfwqurvsydacylgcyohrbou",
                "olmojrovoqseuqausssdupqzhbmyblomlbbqzwgbtgyiwq",
                "tcshhbdgxsrtxywgqahqfimbnckwdhtbzlpwevuqjyqrbd",
                "vjmcknagopzpwrmrianbgyhyginqduwdfjgmdqttcqroof",
                "srmfsjigydlqlgsmvgqddpqmqkjzptzwdfpjmpnvgaezlx",
                "yphbhtrmqcnrfklqmkblvginnhxxtlnnwcfuwujdqwkvaq",
                "jahvrihhicrqvttmdzwbemjjqnstvtudvifdvrbjxalirj"));
        
        testCase(Arrays.asList("zzzzzzzzeqzzzzzzzzezzzzz",
                "zzzzuzzuzzgzzzzzzzzzzzzz",
                "zzzzzzzzzuzzzzzzzzzjzzuz",
                "zzzzuzzzjzzzzzzzzzzzzuzz",
                "vzzzvzzzzzzzzzzzzozzzzzz",
                "zzzzzzzzzzzzzxzzzxzzxzzz",
                "zzzzzzzzxzzzzzzzzxxzzzzz",
                "zzzxzzzzzxzzzzzzzzzzzzzx",
                "xxzzzzzzzzzzzzzzzzzzzzzx",
                "zzzxzzxzzzzzzzzzzzzzzxzz",
                "zzxxxzzzzzzzzzzzzzzzzzzz",
                "zzxzxzzzzzzzzzzzzzzzzxzz",
                "zzzzzzzzxzzzzzzzzzzzxzxz",
                "zzzzzzzzzzzzxzzzzzzzzzzz",
                "zzzzzzzzzzzxzzzzzzzzzzzz",
                "zzzzzzxzzzzzzzzzzzzzzzzz",
                "zzzzzzzzzzzzzzxzzzzzzzzz",
                "zzzzzzzzzzzzzzzzzzzzxzzz",
                "zzzzzzzzzzzzzzzzzzzzzzzx",
                "zzzzzzzzzzzzzzzzxzzzzzzz",
                "zzzzzzzzzzzzzzzzzzzxzzzz",
                "zzzzzzzzxzzzzzzzzzzzzzzz",
                "zzzzzzzzzzzzzzzzzzzzzxzz",
                "xzzzzzzzzzzzzzzzzzzzzzzz"));
        testCase(Arrays.asList("iv",
                "sm"));
    }
    
    private static void testCase(List<String> stringList)
    {
        long start = System.currentTimeMillis();
        System.out.println(GridChallengeResult.gridChallenge(stringList));
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println("time taken: " + sec + " seconds");
    }
}


class GridChallengeResult
{
    
    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    
    public static String gridChallenge(List<String> grid)
    {
        // Write your code here
        
        // iterate over the string list
        // sort each string
        // store the sorted string into new list
        // now check if the strings are lexicographically sorted
        // if sorted then return YES
        // else NO
        List<String> sortedStrings = new ArrayList<>();
        
        for(String original : grid)
        {
            char[] chars = original.toCharArray();
            Arrays.sort(chars);
            sortedStrings.add(String.valueOf(chars));
        }
//        System.out.println("sorted string list: " + sortedStrings);
        /*if (sortedStrings.stream().sorted().collect(Collectors.toList()).equals(sortedStrings))
            result = "YES";*/
        
        for (int i = 0; i < sortedStrings.size() - 1; i++)
        {
//            System.out.println("compare s1: " + sortedStrings.get(i) + ", s2: " + sortedStrings.get(i+1));
            int len = Math.min(sortedStrings.get(i).length(), sortedStrings.get(i + 1).length());
            for (int j = 0; j < len; j++)
            {
                if (sortedStrings.get(i).charAt(j) > sortedStrings.get(i + 1).charAt(j))
                {
                    return "NO";
                }
            }
        }
        
        return "YES";
    }
    
}