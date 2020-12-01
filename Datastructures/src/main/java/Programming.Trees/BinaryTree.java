package Programming.Trees;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/*
   TODO finish up the comments
*  Properties:
*  The maximum number of nodes on level i of a binary tree is 2^i, i>=1
*  The Maximum number of nodes in the binary tree of depth k, 2^(k+1) k>= 1
*  There is exactly on path from the root to any nodes in a tree
*  A tree with N nodes exactly N-1 edges connecting these nodes
*  The height of a complete binary tree of N nodes is Log2(N)
**/
public class BinaryTree {
    // (1) Create a node class
    private static class Node {
    private int value;
    private Node leftChild;
    private Node rightChild;
  // (2) Create a constructor with the proper field variables
    public Node(int value, Node l, Node r){
      this.value = value;
      this.leftChild = l;
      this.rightChild = r;
    }
  // (3) Create another constructor with just the value and assign
    public Node(int value){
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

  }//End of Node Class
    //Field variable in Tree Class
    private Node root;
    //Constructor
    public BinaryTree(){
      root = null;
    }
    public void levelOrderBinaryTree(int [] array){
        root = levelOrderBinaryTree(array, 0);
    }
    public Node levelOrderBinaryTree(int [] array, int start){
        int size = array.length;
        Node current = new Node(array[start]);
        int left = 2 * start +  1;
        int right = 2 * start + 2;
        if( left < size)
            //current left child recursively, passes in the left and right assignments
            current.leftChild = levelOrderBinaryTree(array, left);
        if( right < size)
            current.rightChild = levelOrderBinaryTree(array, right);
        return current;
    }
    /* PreOrder Traversal using recursion at each node, first the value stored
    *  in it is printed and then followed by the value of left child
       int left =  2 * start + 1;
    *  and right child
    *  At each node its value is printed followed by calling printTree function
    * */
    public void PrintPreOrder(){
        PrintPreOrder(root);
    }
    public void PrintPreOrder(Node node){
        if(node != null){

            System.out.print(" " + node.value);
            PrintPreOrder(node.leftChild);
            PrintPreOrder(node.rightChild);
        }
    }

    public void PrintPostOrder(){
        PrintPostOrder(root);
   }

    public void PrintPostOrder(Node node){
        if(node != null){
            PrintPostOrder(node.leftChild);
            PrintPostOrder(node.rightChild);
            System.out.print(" " + node.value);
        }
    }
    public void PrintPostOrderIteratively(){
        PostorderIteration(root);
    }
    public void PostorderIteration(Node root) {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        // push the root node into first stack.
        s1.push(root);
        while (s1.isEmpty() == false) {
            // take out the root and insert into second stack.
            Node temp = s1.pop();
            s2.push(temp);
            // now we have the root, push the left and right child of root into
            // the first stack.
            if(temp.leftChild!=null){
                s1.push(temp.leftChild);
            }
            if(temp.rightChild!=null){
                s1.push(temp.rightChild);
            }
        }
        //once the all node are traversed, take out the nodes from second stack and print it.
        while(s2.isEmpty()==false){
            Node temp = s2.pop();
            System.out.print(" " + temp.value);
        }
    }
    public void PrintInOrder(){
        PrintInOrder(root);
    }
    public void PrintInOrder(Node node){
        if(node != null){
            PrintInOrder(node.leftChild);
            System.out.print(" " + node.value);
            PrintInOrder(node.rightChild);
        }
    }
    //Printing BFT of tree traversal is best using Queue
    public void PrintBreadthFirst(){
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        Node tmp;
        if(root != null)
            queue.add(root);
        while(queue.isEmpty() == false){
            tmp = queue.remove();
            System.out.print(" " +tmp.value);

            if(tmp.leftChild != null)
                queue.add(tmp.leftChild);
            if(tmp.rightChild != null)
                queue.add(tmp.rightChild);
        }
    }
    //Printing DFT of tree traversal is best using stack
    public void PrintDepthFirst(){
        ArrayDeque<Node> stack = new ArrayDeque<Node>();
        Node tmp;

        if(root != null)
            stack.push(root);
        while(stack.isEmpty() == false){

            tmp = stack.pop();

            System.out.print(" " + tmp.value);
            if(tmp.leftChild != null)
                stack.push(tmp.leftChild);
            if(tmp.rightChild != null)
                stack.push(tmp.rightChild);
        }
    }
    public int TreeDepth(){
        return TreeDepth(root);
    }
    //Tree Depth is sometimes useful as it can give the run time for balanced trees
    private int TreeDepth(Node root){
        if(root == null)
            return 0;
        else{
            int leftDepth = TreeDepth(root.leftChild);
            int rightDepth = TreeDepth(root.rightChild);

            if(leftDepth > rightDepth)
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }
    }
    //Nth Ordered:  Pre-Order
    public void NthPreOrdered(int index){
        int[] count = {0};
        NthPreOrdered(root, index, count);
    }

    private void NthPreOrdered(Node node, int index, int[] count){
        if(node != null){
            count[0]++;
            if(count[0] == index){
                System.out.print(" " + node.value);
            }
            NthPreOrdered(node.leftChild, index, count);
            NthPreOrdered(node.rightChild, index, count);
        }
    }

    public void NthPostOrdered(int index){
        int [] counter = {0};
        NthPostOrdered(root, index, counter);
    }

    private void NthPostOrdered(Node node, int index, int[] counter){
        if(node != null){
            NthPostOrdered(node.leftChild, index, counter);
            NthPostOrdered(node.rightChild, index, counter);
            counter[0]++;
            if(counter[0] == index){
            System.out.print(" " + node.value);
            }
        }
    }

    public void NthInOrder(int index){
        int[] counter = {0};
        NthInOrder(root, index, counter);
    }
    private void NthInOrder(Node node, int index, int[] counter){
        if(node != null){
            NthInOrder(node.leftChild, index, counter);
            counter[0]++;
            if(counter[0] == index){
            System.out.print(" " + node.value);
            }
            NthInOrder(node.rightChild, index, counter);
        }
    }
    //TODO remove the main method here and setup tests in the test folder
    public static void main(String [] args){
        BinaryTree bt = new BinaryTree();
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        bt.levelOrderBinaryTree(arr);
        System.out.println("Pre-Ordered-Recursive");
        bt.PrintPreOrder();
        System.out.println("");
        System.out.println("Pre-Ordered-Iteratively");

        //       bt.PrintPreOrderIteratively();
        System.out.println("");
        System.out.println("Post-Ordered-Recursive");
        bt.PrintPostOrder();
        System.out.println("");
        System.out.println("Post-Ordered-Iteratively");
        bt.PrintPostOrderIteratively();
        System.out.println(" ");
        System.out.println("In Order");
        bt.PrintInOrder();
        System.out.println("");
        System.out.println("Print Breadth First Traversal");
        bt.PrintBreadthFirst();
        System.out.println("");
        System.out.println("Print Depth First Traversal");
        bt.PrintDepthFirst();
        System.out.println(" ");
        System.out.println("Tree Depth ");
        System.out.println(bt.TreeDepth());
        System.out.println("");
        System.out.println("Nth PreOrdered");
        bt.NthPreOrdered(8);  //is 3 in pre-ordered
        System.out.println("");
        System.out.println("Nth PostOrdered");
        bt.NthPostOrdered(8);
        System.out.println("");
        System.out.println("Nth InOrder");
        bt.NthInOrder(9);
    }
}
