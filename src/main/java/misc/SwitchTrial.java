package misc;

/**
 * Created by APahwa on 10/27/2017.
 */
public class SwitchTrial {

    public static void main(String[] args)
    {
        int i = 1;

        switch (i)
        {
            case 0:
                System.out.print("ZERO");
                break;
            case 2:
                System.out.print("ONE");
                break;
            default:
                System.out.print("Unknown value : " + i);
                break;
        }
    }

}
