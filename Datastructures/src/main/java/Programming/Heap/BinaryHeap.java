package Programming.Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private static final int d=2;
    private int[] heap;
    private int heapCapacity;

    public BinaryHeap(int capacity){
        heapCapacity =0;
        heap = new int[capacity+1];
        Arrays.fill(heap, -1);
    }
    public boolean isEmpty(){return heapCapacity ==0;}

    public boolean isFull(){return heapCapacity == heap.length;}

    public int parent(int i){return (i-1)/d;}

    public int kthChild(int i, int k){
        return 2*i + k;
    }
    public void insert(int x){
        if(isFull())
            throw new NoSuchElementException("Heap is full, no space o insert");
        heap[heapCapacity++] = x;
        heapifyUp(heapCapacity-1);
    }
    public int delete(int x){
        if(isEmpty())
            throw new NoSuchElementException("Heap is empty");
        int key = heap[x];
        heap[x] = heap[heapCapacity-1];
        heapCapacity--;
        heapifyDown(x);
        return key;
    }
    public int maxChild(int i){
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);

        return heap[leftChild] > heap[rightChild] ? leftChild: rightChild;
    }
    public void heapifyDown(int i){
        int child;
        int temp = heap[i];
        while(kthChild(i, 1) < heapCapacity){
            child = maxChild(i);
            if(temp < heap[child]){
                heap[i]= heap[child];
            }else
                break;
                i = child;
            }
        heap[i]= temp;
    }

    public void heapifyUp(int i){
        int temp = heap[i];
        while(i > 0 && temp > heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);

        }
        heap[i] = temp;
    }
    public void print(){
        System.out.print("Heap =");
        for(int x : heap){
            System.out.print(x + " ");
        }
    }
    public int max(){
        if(isEmpty()) throw new NoSuchElementException("Heap is empty");
        return heap[0];
    }
    public static void main(String[] args){
        BinaryHeap o = new BinaryHeap(10);
        o.insert(10);
        o.insert(4);
        o.insert(9);
        o.insert(1);
        o.insert(7);
        o.insert(5);
        o.insert(3);
        o.insert(6);
        o.insert(2);
        o.insert(0);
        o.insert(-1);

        o.print();
        o.delete(5);
        o.print();
        o.delete(4);
        o.print();
    }

}