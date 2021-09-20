package Programming.Trees;
import java.nio.BufferUnderflowException;

//Most operations of BinarySearch Tree are O(lg n)
public class BinarySearchTree<Object extends Comparable<? super Object>> {

    //non-static
    private BinaryNode<Object> root;

    //constructor
    public BinarySearchTree() {
        root = null;
    }

    /* Methods */
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(Object x) {
        return contains(x, root);
    }

    public Object findMin() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public Object findMax() {
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(Object x) {
        root = insert(x, root);
    }

    public void remove(Object x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty Tree");
        else
            printTree(root);
    }


    //You could do this further by breaking up the print statements
    //To print different orders this is inOrderPrint, postOrderPrint, preOrderPrint
    public void printTree(BinaryNode<Object> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }


    /*
    contains method using compareTo
       An int value: 0 if the string is equal to the other string.
       < 0 if the string is lexicographically less than the other string
       > 0 if the string is lexicographically greater than the other string (more characters)
    **/
    private boolean contains(Object x, BinaryNode<Object> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    private BinaryNode<Object> findMin(BinaryNode<Object> t) {
        if (t == null) {
            return null;
        } else if (t.left == null) {
            return t;
        } else {
            return findMin(t.left);
        }
    }

    private BinaryNode<Object> findMax(BinaryNode<Object> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }
    private BinaryNode<Object> insert(Object x,BinaryNode<Object>t){
        if(t == null){
            return new BinaryNode<Object>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);

        if(compareResult < 0) {
            t.left=insert(x,t.left);
        }else if(compareResult > 0){
            t.right = insert(x, t.right);
        }else{
            ;
        }
        return t;
    }
    private BinaryNode<Object> remove(Object x, BinaryNode<Object> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult > 0) {
            t.left = remove(x, t.left);
        } else if (compareResult < 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }
}//End of File


