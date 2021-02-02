package Programming.Collections;

import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object [] elements;

    public ArrayList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public Object add(E e){
        if(size == elements.length){
            testCapacity();
        }
       return elements[size++] = e;
    }

    private void testCapacity(){
        int newSize = elements.length*2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int i){
        if(i >= size || i < 0){
            throw new IndexOutOfBoundsException("Idx: " + i + ",Size " + i);
        }
        return (E) elements[i];
    }
}
