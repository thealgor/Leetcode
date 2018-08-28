/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return -1;

        double minDiff = Double.MAX_VALUE;
        int minValue = -1;

        while(root!=null){

            double diff = Math.abs(root.val - target);

            if(diff<minDiff){
                minDiff = diff;
                minValue = root.val;
            }

            if(root.val > target){
                root = root.left;
            }
            else if(root.val<target)
                root = root.right;
            else
                return root.val;

        }
        return minValue;
    }
}