package Programming.Linkedlists;
/**
 * CircularLinklist
 *
 * Advantage:
 *
 * Disadvantage:
 *
 * Good Use Case:
 **/
public class CircularLinklist {
    private Node head;
    private Node next;
    private int data;
    //Extending Node Class
    public CircularLinklist(int data) {
        this.data = data;
    }
    //Iterates through the nodes and looks for where it returns the tail
    public void appendToTail(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        //update the tail
        tail().next = new Node(data);
    }
    //Iterates through the nodes given data and add it to the end of the list
    public Node tail(){
        Node tail = head;
        while(tail.next != head){
            tail = tail.next;
            tail.next.next = head.next;
            tail.next = head;
            head = head.next;
        }
        return head;
    }
    //Returns the count of the nodes while iterating through O(n)
    public int length(){
        int length = 0;
        Node current = head;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }
    //Iterates through the nodes and looks for where it returns the tail
    // function for traversing the list
    static void traverseHeadToTail(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}
