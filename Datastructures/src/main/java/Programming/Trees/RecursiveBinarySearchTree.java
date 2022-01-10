package Programming.Trees;

public class RecursiveBinarySearchTree {
    public static void main(String [] args){
        int [] nums = { 2,3,5,9,12,13,15};
        int key = 12;

        int left = 0;
        int right = nums.length-1;
        int idx = binarySearch(nums, left, right, key);

        if(idx != -1)
             System.out.println("Element found at " + idx);
        System.out.println("Element not found in the array");
    }


    public static int binarySearch(int[] nums, int left, int right, int key){
        if(left > right){
            return -1; //not in array
        }
         int mid = left + (right-left) / 2;

        if(key == nums[mid]){
            return mid;
        }
        else if(key < nums[mid]){
            return binarySearch(nums, left, mid-1, key);
        }
        else{
            return binarySearch(nums, mid + 1, right, key);
        }
    }

}
