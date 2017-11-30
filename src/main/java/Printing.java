import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by APahwa on 9/5/2017.
 */
public class Printing {

    public static void main(String[] args) {
        Set<String> listDevice = new HashSet<String>(Arrays.asList("Device1", "Device2", "Device3"));

        System.out.println(String.format("Generating quick tasks with selective wipe for devices : %s", listDevice.toString()));
        test1();

        if(new IllegalArgumentException() instanceof RuntimeException)
            System.out.println("TRUE");

        int x = 10;
        int y = 15;

        Printing.add(x,y);
        System.out.println("add : " + x);
    }

    private boolean getVal() { return true ;}

    public static void add(int x, int y)
    {
        x = x+y;
    }

    public static void test1()
    {
        boolean keepGoing = true;
        int count = 0;
        int x = 3;
        while (count++ < 3)
        {
            System.out.println("Count : " + count);
            int y = (1 + 2 * count) % 3;
            System.out.println("Y : " + y);
            switch (y)
            {
                default:
                case 0:
                    x -= 1;
                    break;
                case 1:
                    x += 5;
            }
        }
        System.out.println(x);
    }

}

class Trial extends Printing
{
    public boolean getVal()
    {
        return false;
    }
}