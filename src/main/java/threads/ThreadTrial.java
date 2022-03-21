package threads;

public class ThreadTrial
{
    public static void main(String[] args)
    {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Max memory: " + Runtime.getRuntime().maxMemory());
    }
}
