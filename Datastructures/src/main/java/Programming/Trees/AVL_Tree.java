package Programming.Trees;


public class AVL_Tree<T> implements TreeNode<T> {
    private Integer left = null;
    private Integer right = null;
    private Integer height = null;
    private Integer data = null;

    private TreeNode root;

    public AVL_Tree(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void makeEmpty(){
        root = null;
    }


    @Override
    public Integer insert(T data) {
        return null;
    }

    @Override
    public Integer find(T data) {
        return null;
    }

    @Override
    public Integer print() {
        return null;
    }

    @Override
    public Integer delete() {
        return null;
    }
}
