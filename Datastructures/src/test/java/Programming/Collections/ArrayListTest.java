package Programming.Collections;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayListTest {
    ArrayList<Integer> list;
    @Before
    public void init(){
        list = new ArrayList<Integer>();
    }
    @Test
    public void addElement(Object element){
        assertEquals(list.add(3),list.get(0) );
    }


}
