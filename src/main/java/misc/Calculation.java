package misc;

import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Calculation
{
    public static void main(String[] args)
    {
        Calculate addition = Integer::max;
    
        System.out.println(addition.add(3,2));
    
        System.out.println(addition.multiply(3,2));
        
        new Thread((() -> System.out.println("Run method"))).start();
        
        Consumer<String> stringConsumer = stringValue -> System.out.println(stringValue.toLowerCase(Locale.ROOT));
        
        stringConsumer.accept("Hello World");
    
        BiConsumer<Integer, Integer> integerBiConsumer = (integer, integer2) -> System.out.println(integer / integer2);
        
        integerBiConsumer.accept(2,2);
        
        Predicate<String> stringPredicate = stringValue -> null == stringValue || stringValue.isEmpty();
    
        System.out.println("Is string null/empty : " + stringPredicate.test("Hello World"));
        System.out.println("Is string null/empty : " + stringPredicate.test(""));
        System.out.println("Is string null/empty : " + stringPredicate.test(null));
        
        BiPredicate<Integer, Integer> integerBiPredicate = (integer, integer2) -> integer.equals(integer2);
    
        System.out.println("Are ints same : " + integerBiPredicate.test(1,1));
        System.out.println("Are ints same : " + integerBiPredicate.test(1,0));
        
        
        Function<String, String> stringFunction = stringValue -> stringValue.toUpperCase(Locale.ROOT);
    
        System.out.println(stringFunction.apply("hello world"));
        
        BiFunction<Integer, Integer, String> biFunction = ((integer, integer2) -> integer.compareTo(integer2) == 0 ? "Equals" : "Not Equals");
    
        System.out.println("comparision of integers : " + biFunction.apply(2,2));
        
        Supplier<String> stringSupplier = () -> "String suplied";
    
        System.out.println(stringSupplier.get());
    }
}
