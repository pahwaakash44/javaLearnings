import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.Pack200;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by APahwa on 10/30/2017.
 */
public class StringReplace
{
    private static Map<String,String> replaceSpecialCharsMap = new HashMap<String,String>()
    {
        {
            put("\\[", "\\(");
            put("\\]", "\\)");
            put("\\{","\\'\\{\\'");
            put("\\}","\\'\\}\\'");
        }
    };

    public static String replaceSpecialChareters(String input)
    {
        if(input != null)
        {
            Set<Map.Entry<String,String>> set = replaceSpecialCharsMap.entrySet();
            for(Map.Entry<String,String> entry : set)
            {

                input = input.replaceAll(entry.getKey(), entry.getValue());
            }
        }
        return input;
    }

    public static void main(String[] args)
    {
//        String str = "{akash} pahwa from microfocus";
//        System.out.print(replaceSpecialChareters(str));
        System.out.print(getDefaultMessageFormat());
//        System.out.print(getDefaultMessageFormat1());

    }

    public static String getDefaultMessageFormat()
    {
//        return new MessageFormat(messageID, Locale.ENGLISH).format(messageParams);
        String messageID = "Invalid [input] parameters {'deviceGUID': {0}, policyId: {1}, source: {2}}";
        Object[] messageParams = new Object[]{"1234",null,null};

        if((null != messageParams) && (messageParams.length > 0))
        {
            for(int i = 0; i < messageParams.length; i++)
            {
                /*Pattern pattern = Pattern.compile();
                Matcher matcher = pattern.matcher(messageID);
                messageID.replace("\\{([0-9]?)\\}",(null==messageParams[i]?"null":messageParams[i].toString()));
                messageID.replace("\\{([0-9].*)\\}"," DONE ");*/
//                Pattern p = Pattern.compile("(\\{("+i+")\\})");
//                Matcher m = Pattern.compile("(\\{("+i+")\\})").matcher(messageID);
//                while (m.find())
//                {
//                    System.out.println(m.group());
//                    String val1 = m.group().replace("{", "").replace("}", "");
//                    System.out.println(val1);
//                    messageID = (messageID.replace(m.group(), (null == messageParams[i] ? "null" : messageParams[i].toString())));
                    messageID = messageID.replaceAll("(\\{("+i+")\\})",(null == messageParams[i] ? "null" : messageParams[i].toString()));
//                }
            }
        }
        /*int i = 2;
        Pattern p = Pattern.compile("(\\{("+i+")\\})");
        Matcher m = p.matcher(messageID);
        while (m.find()) {
            System.out.println(m.group());
            String val1 = m.group().replace("{", "").replace("}", "");
            System.out.println(val1);
            messageID = (messageID.replace(m.group(), (null==messageParams[i]?"null":messageParams[i].toString())));
            System.out.println("");
        }*/
//        messageID = messageID.replace("{0}","REPLACED");

        return messageID;
    }

    public static String getDefaultMessageFormat1()
    {
        String messageID = "Invalid input parameters {deviceGUID: {0}, policyId: {1}, source: {2}}";
        int i = 0;
        messageID = messageID.replaceAll("(\\{("+i+")\\})","REPLACED_VAL");
        return messageID;
    }
}
