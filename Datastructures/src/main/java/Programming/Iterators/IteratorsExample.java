package Programming.Iterators;
/*
*   An Iterator is an object that can be used to loop through collections,
*   like ArrayList and HashSet. It is called an "iterator" because "iterating"
*   is the technical term for looping.
*   To use an Iterator, you must import it from the java.util package.
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorsExample implements Iterator {
    static ArrayList<String> fruits = new ArrayList<String>(Arrays.asList("banana", "apple","dragon fruit","cocoa"));
    static Iterator<String> itr = fruits.iterator();

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
    public static void main(String [] args){
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
