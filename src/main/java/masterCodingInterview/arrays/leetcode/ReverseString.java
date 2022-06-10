package masterCodingInterview.arrays.leetcode;

public class ReverseString
{
    public static void main(String[] args)
    {
        String inputString = "Hi My name is Akash";
        System.out.println("Reversed String: " + getReversedString(inputString));

        inputString = "  ";
        System.out.println("Reversed String: " + getReversedString(inputString));

        inputString = " 123 ";
        System.out.println("Reversed String: " + getReversedString(inputString));

        inputString = "null";
        System.out.println("Reversed String: " + getReversedString(inputString));
    }

    static String getReversedString(String inputString)
    {
        if (inputString == null || inputString.trim().isEmpty()) return "String is empty or null";

        StringBuilder stringBuilder = new StringBuilder();
        char[] characters = inputString.toCharArray();

        for (int i = characters.length - 1; i >= 0; i--)
        {
            stringBuilder.append(characters[i]);
        }
        return stringBuilder.toString();
    }
}
