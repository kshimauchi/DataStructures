package Programming.PriorityQueue;

import java.util.LinkedList;


public class PriorityQueue {

    static class Node{
        int data;
        Node next;
        int priority;
    }
    static Node node = new Node();

    static Node newNode(int data, int priority){
        Node node = new Node();
        node.data = data;
        node.priority = priority;
        node.next = null;

        return node;
    }
    static int peek(Node head){
        return head.data;
    }

    static Node pop(Node head) {
        Node temp = head;
        (head) = (head).next;
        return head;
    }

    static Node push(Node head, int data, int priority){
        Node start = head;
        Node node = newNode(data, priority);

        if(head.priority > priority){
            node.next = head;
            head = node;
        }else{
            while(start.next != null && start.next.priority < priority){
                start = start.next;
            }
            node.next = start.next;
            start.next = node;
        }
        return head;
    }



    static int isEmpty(Node head){
        return head == null ? 1:0;
    }

    public static void main(String [] args) {
        Node pq = newNode(2, 1);
        pq = push(pq, 5, 2);
        pq = push(pq, 6, 3);
        pq = push(pq, 7, 0);

        while (isEmpty(pq) == 0) {
            System.out.printf("%d ", peek(pq));
            pq = pop(pq);
        }

    }

}
