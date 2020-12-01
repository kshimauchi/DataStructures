package Programming.Stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackTest {
    Stack s;

    @Before
    public void init(){
        s = new Stack(15);
    }

    @Test
    public void isPushTest(){
        s.push(2658328);
        s.push(12345);
        s.push(4904389);
        s.push(390288432);
        Assert.assertEquals(s.peek(), 390288432);
        //we gonna pop to make life faster
        s.pop();
        Assert.assertEquals(s.peek(), 4904389);
        s.pop();
        Assert.assertEquals(s.peek(), 12345);
        s.pop();
        Assert.assertEquals(s.peek(),2658328);

    }
    @Test
    public void isEmpty() {
        Assert.assertFalse(s.isEmpty());
    }
    @Test
    public void pop(){
        Stack s = new Stack(3);
        s.push(1);
        s.push(2);
        s.push(3);
        Assert.assertEquals(s.pop(), 3);
        Assert.assertEquals(s.pop(), 2);
        Assert.assertEquals(s.pop(), 1);
    }
    @Test
    public void peek(){
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(2);
        s.push(3);
        /* should test negatives */
        Assert.assertEquals(s.peek(), 3);
        s.pop();
        Assert.assertEquals(s.peek(), 2);
        s.pop();
        Assert.assertEquals(s.peek(), 3);
        s.pop();
        Assert.assertEquals(s.peek(), 2);
        s.pop();

        Assert.assertEquals(s.peek(), 1);
        s.pop();
    }

}
