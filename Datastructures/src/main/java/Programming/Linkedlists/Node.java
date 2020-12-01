package Programming.Linkedlists;

public class Node {
    public Node next;
    public int data;
    private int leftChild;
    private int rightChild;

    //Right away you should know this only is good for single linked list or maybe
    //Circular linked list if you point the next pointer of the tail, back to the head
    //these you should not rush through they are confusing and if you write down
    //something that resembles a train of box cars you will be ok!

    public Node(int data) {
        this.data = data;
    }

    //For Tree
    public Node(int data, int leftChild, int rightChild){
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }



    
}

