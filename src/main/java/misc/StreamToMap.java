package misc;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamToMap
{
    public static List<Person> createPeople()
    {
        return Arrays.asList
                (
                        new Person("Sara", Gender.FEMALE, 20),
                        new Person("Sara", Gender.FEMALE, 22),
                        new Person("Bob", Gender.MALE, 20),
                        new Person("Paula", Gender.FEMALE, 32),
                        new Person("Paul", Gender.MALE, 32),
                        new Person("Jack", Gender.MALE, 2),
                        new Person("Jack", Gender.MALE, 72),
                        new Person("Jill", Gender.FEMALE, 12)
                );
    }
    
    public static void main(String[] args)
    {
        // create map with the KEY<name,age> and VALUE<Person>
        
        List<Person> personList = createPeople();
        
        //        System.out.println(
        //        personList.stream()
        //                .collect(toMap(
        //                        person -> person.getName() + "-" + person.getAge(),
        //                        person -> person)));
        
        System.out.println(
                personList.stream()
                        .collect(groupingBy(
                                Person::getName,
                                mapping(Person::getAge, toList())
                        ))
        );
    }
}
