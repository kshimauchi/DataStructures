package Programming.Queue;

public class Queue {
    private int capacity;
    private int head;
    private int tail;
    private int[] queueContainer;

    public Queue(int capacity) {
        this.capacity = capacity;
        head = 0;
        tail = 0;
        queueContainer = new int[capacity];
    }
    public void Enqueue(int data) {
        //TODO make the array dynamically expandable by doubling
        if (capacity == tail) {
            //create a new array container double size
            //copy over
            //Unfortunately this is not efficient
            System.out.println("Queue is full need to provide space !");
        }else{
            queueContainer[tail]= data;
            tail++;
        }
    }
    public void Dequeue(){
        if(head == tail){
            System.out.println("Queue is Empty !");
        }else{
            for(int i=0; i < tail-1; i++){
                queueContainer[i] = queueContainer[i + 1];
            }
        }
        if(tail < capacity) queueContainer[tail] = 0;
        tail--;
    }
    public void printQueue(){
        int i;
        if(head == tail){
            System.out.println("Queue is Empty !");
        }
        for(i = head; i < tail; i++){
            System.out.printf("%d <-- ", queueContainer[i]);
        }
    }
    public void queueHead(){
        if(head == tail){
            System.out.println("Queue is Empty ");
        }
        System.out.println(" Head Element is: " + queueContainer[head]);
    }


}
