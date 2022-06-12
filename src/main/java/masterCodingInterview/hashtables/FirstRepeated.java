package masterCodingInterview.hashtables;

import java.util.Hashtable;

public class FirstRepeated
{
    public static void main(String[] args)
    {
        System.out.println(getFirstRepeatedElement(new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(getFirstRepeatedElement(new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}));
        System.out.println(getFirstRepeatedElement(new int[]{2, 4, 5}));
    }

    static int getFirstRepeatedElement(int[] nums)
    {
        Hashtable<Integer, String> numHashTable = new Hashtable<>();
        for (int i : nums)
        {
            if ((numHashTable.put(i, "PRESENT") != null))
                return i;
        }
        return -1;
    }


}
