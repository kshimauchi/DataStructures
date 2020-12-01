package Programming.Linkedlists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SinglyLinkedlistTest{
    SinglyLinklist s;

    @Before
    public void init(){
        s = new SinglyLinklist();
    }

    @Test
    public void isEmptyTest(){
        Assert.assertEquals(s.length(), 0);
        Assert.assertEquals(s.length()==0, true);
        Assert.assertEquals(s.length() == -1, false);
        s.appendToTail(1);
        Assert.assertEquals(s.length(), 1);
        s.appendToTail(3);
    }
    //TODO later
    @Test
    public void appendToTailTest(){

    }
    @Test
    public void tailTest(){

    }
    @Test
    public void lengthTest(){

    }
}
