package Programming.Heap;
/*
A Min/Max heap is typically represented as an array.
Arr[0] Returns the root node.
Arr[(i-1)/2] Returns the parent node.
Arr[(2*i)+1] Returns the left child node.
Arr[(2*i)+2] Returns the right child node.
Using an array:
*/
public class MaxHeap {
    private int[] Heap;
    private int capacity;
    private int maxsize;

    //initialize the max heap
    public MaxHeap(int capacity){
        this.capacity = capacity;
        capacity =0;
        Heap = new int[this.capacity + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    //Position of Parent:
    public int parent(int position){
        return position / 2;
    }
    public int leftChild(int position){
        return (2 * position);

    }
    public int rightChild(int position){
        return (2 * position) + 1;
    }
    public boolean isLeaf(int position){
        if(position >= capacity/2 && position <= capacity){
            return true;
        }
        return false;
    }
    public void swap(int first, int second){
        int temp;
        temp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = temp;
    }
    //A recursive function to maxHeapify
    public void maxHeapify(int position){
        if(isLeaf(position)) return;

        if(Heap[position] < Heap[leftChild(position)]
        || Heap[position] < Heap[rightChild(position)]){
                if(Heap[leftChild(position)] > Heap[rightChild(position)]){
                    swap(position, leftChild(position));
                    maxHeapify(leftChild(position));
                }else{
                    swap(position, rightChild(position));
                    maxHeapify(rightChild(position));
                }
        }
    }
    public void insert(int element){
        Heap[++capacity] = element;
        //traverse up and fix violated property
        // Traverse up and fix violated property
        int current = capacity;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void print(){
        for(int i=0; i <= capacity/2; i++){
      System.out.print("Parent "   );
        }
    }
}
