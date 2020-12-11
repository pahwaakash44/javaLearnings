package misc;

public class LocalVariables
{
    static String str;
    static int i;

    public static void main(String[] args)
    {
        extractData();

        System.out.println("str : " + str);
        System.out.println("i : " + i);
    }

    public static void extractData()
    {
        str = "Hello World";
        i = 1;
    }
}
