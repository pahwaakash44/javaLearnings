package misc;

@FunctionalInterface
public interface Calculate
{
    int add(int x, int y);
    
    default int multiply(int x, int y)
    {
        return x * y;
    }
}
