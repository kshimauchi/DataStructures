package Programming.Linkedlists;
/**
 * SingleLinkedList
 *
 * Advantage:
 *
 * Disadvantage:
 *
 * Good Use Case:
 **/
public class SinglyLinklist {
    //self-explanatory
    private Node head;

    //return the length from the length Method and evaluation is done here
    //How do you check the length of a singly linked list ?
    public boolean isEmpty(){
        return length()==0;
    }
    //Iterates through the nodes given data and add it to the end of the list
    public void appendToTail(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }
    //Iterates through the nodes and looks for where it returns the tail
    public Node tail(){
        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
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
    //Inner class for a linked list this could be alot of Objects here we use the term node
    //Node contains data and reference to the next node
    class Node {
        private Node next;
        private int data;
        //Constructor here with a simple data
        public Node(int data) {
            this.data = data;
        }
    }
}
