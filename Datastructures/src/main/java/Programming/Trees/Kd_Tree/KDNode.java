package Programming.Trees.Kd_Tree;


public class KDNode <Object> {
    Object element;
    KDNode<Object> left;
    KDNode<Object> right;

    public KDNode(Object theElement){
        this(theElement, null, null);
    }

    public KDNode(Object theElement, KDNode<Object> left, KDNode<Object> right){
        element = theElement;
        this.left = left;
        this.right = right;
    }

}
