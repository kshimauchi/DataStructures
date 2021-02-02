package Programming.Sets;

import java.util.*;
import java.util.stream.Collectors;

// The Java Set Interface represent an unordered collection of unique elements
//
public class Sets {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();

        //add, unique
        set1.add("This contains a string");
        set1.add("This is a string");
        System.out.println(set1.toString());

        //add
        set2.add("This is a string");
        System.out.println(set1.contains(set2));

        //We can check common elements using sets quickly
        boolean intersectionResult = set1.retainAll(set2);
        //Is set1 and set2 union
        System.out.println("set1 retainAll set2 :" + set1.toString() + " " + set2.toString() + "result" +
                " " + intersectionResult);

        List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
        List<String> otherList = Arrays.asList("red", "green", "green", "yellow");
        //Java 8 using String map, filter and collect
        Set<String> result = list.stream()
                .distinct()
                .filter(otherList::contains)
                .collect(Collectors.toSet());

        Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));
        System.out.println(Arrays.toString( result.toArray() ));
    }
}
// The Java Set Interface represent an unordered collection of unique elements
