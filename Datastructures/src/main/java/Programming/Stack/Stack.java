package Programming.Stack;
/*Stack: using a array */
public class Stack {
    private int maxSize;
    private long[] stackContainer;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackContainer = new long[maxSize];
        top = -1;
    }

    public void push(long e) {
        stackContainer[++top] = e;
    }

    public long pop() {
        return stackContainer[top--];
    }

    public long peek() {
        return stackContainer[top];
    }

    public boolean isEmpty() {
        return (top == maxSize - 1);
    }
}