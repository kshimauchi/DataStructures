package Programming.Trees;

public class BinaryNode<Object> {
    Object element;
    BinaryNode<Object> left;
    BinaryNode<Object> right;

    public BinaryNode(Object theElement){
        this(theElement, null, null);
    }
    public BinaryNode(Object theElement, BinaryNode<Object> left, BinaryNode<Object> right){
        element = theElement;
        this.left = left;
        this.right = right;

    }

}
