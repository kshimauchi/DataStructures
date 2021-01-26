package Programming.Trees;

public interface TreeNode<T> {
    int key = 0 ;
    int height = 0;
    TreeNode left = null;
    TreeNode right = null;

    /*Insert: an element into a Tree */
    public Integer insert(T data);
    /*Search: Search for element in a Tree*/
    public Integer find(T data);
    /*Print:  Print the Tree as a list in some order: pre-order, in-order, post-order */
    public Integer print();
    /*Remove: element with given value*/
    public Integer delete();






}
