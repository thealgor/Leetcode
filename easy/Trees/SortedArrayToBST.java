package Trees;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0)
            return null;

        TreeNode root = sortedArrayToBST(nums, 0, nums.length-1);
        return root;

    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi){

        if(lo>hi)
            return null;

        int mid = (int)Math.ceil((lo+hi)/2);

        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, lo, mid-1);
        root.right = sortedArrayToBST(nums,mid+1,hi);
        return root;
    }


}