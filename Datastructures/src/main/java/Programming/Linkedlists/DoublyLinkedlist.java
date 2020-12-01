package Programming.Linkedlists;
/**
 * Advantages over singly linked list
 * 1) A Double Linked List can be traversed in both forward and backward direction.
 *    (making insertion deletion efficient at the head or tail)
 * 2) The delete operation in DLL is more efficient if pointer to the node to be
 *    deleted is given.
 *
 * 3) We can quickly insert a new node before a given node. In singly linked list,
 *    to delete a node, pointer to the previous node is needed. To get this previous node, sometimes the
 *    list is traversed. In DLL, we can get the previous node using previous pointer.
 */
public class DoublyLinkedlist {

    private Node head;

  class Node {
    /*References nodes */
    private Node previous;
    private Node next;

    private int data;

    public Node(int data) {
      this.data = data;
    }
    public void appendToHead(int data){
      //Create a current node with value data
      Node current = new Node(data);
      //make the next node as head
      current.next = head;
      //since we are adding to the front of the list
      //make the previous node point to null
      current.previous = null;
      //make the current node the new head
      if(head != null)
        head.previous = current;
      //reconnect the head to point
      head = current;
      }
      //adds a new node next to a given node
      public void appendToNext(Node previous,int data){
        //check if the given previous node is NULL
        if(previous == null){
          System.out.println("ERR on pointer to previous");
        }
        //create the node with data
        Node current = new Node(data);
        //Double linked list can be traversed in both directions
        //we are essentially creating a pointer so we have to assign current node to the previous.next position
        //Makes the current node next to the previous node */
        current.next = previous.next;
        //Makes the previous next where we are */
        previous.next = current;
        //reconnects the current.previous reference back to the previous node
        current.previous = previous;
        //if this is not the end of the tail
        if(current.next != null)
          //we point the old pointer that connected the next node, to the previous node back to our current node
          //since it basically cuts a holes in the references
          current.next.previous = current;
      }
      public void appendToTail(int data){
        //creates a node with data
        Node current = new Node(data);
        //calls the last node the head
        Node last = head;
        //makes a node next to the last node null as to indicate the end
        current.next = null;
        //Checks if the list is empty if it is
        if (head == null) {
          //then we create a new node as the head
          current.previous = null;
          head = current;
        }
        //Otherwise we continue traversing until we get to the last node
        while(last.next != null){
          //adding a place for the next node
          last = last.next;
        }
          //adding the current node to the next to last position
        last.next = current;
        //pointing the newly created last node to point to the previous node
        current.previous = last;
      }
  }
}
