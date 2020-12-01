package Programming.Stack;

public class StackLinkedlist {
    //TODO finish later
    class Node{
    int data;
    Node ref;
    }

    public Node top;

    public StackLinkedlist()
    {
        this.top = null;
    }
    public void push(int x){
        Node tmp = new Node();
        if(tmp == null){
            return;
        }
        tmp.data = x;
        top.ref = top;
        top = tmp;
    }
    public void pop(){
        if(top == null){
            return;
        }
        top = top.ref;
    }
    public void print(){
        if(top == null){
            System.out.println("Error:  no elements");

        }else{
            Node tmp = top;
            while(tmp != null){
                System.out.printf("%d--->", tmp.data);
                tmp = tmp.ref;
            }

        }

    }
}
