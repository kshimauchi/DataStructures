package Programming.Trees;

public class Driver {
    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(2);
        bst.insert(20);
        bst.insert(10);
        bst.insert(13);
        bst.insert(93);
        bst.insert(11);
        bst.insert(22);

        System.out.println("Contains 10 " + bst.contains(10));
        System.out.println("Minimum: " + bst.findMin());
        System.out.println("Maximum: " + bst.findMax());
        bst.remove(2);
        System.out.println("remove 2 " + bst.contains(2));
        //in order print traversal left root right
        bst.printTree();


    }
}
