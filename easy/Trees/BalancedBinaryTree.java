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

    //another same solution as mine
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }



    public boolean isBalanceddd(TreeNode root) {
        if(root==null)
            return true;

        int v = isBalancedd(root);
        if(v==Integer.MAX_VALUE)
            return false;

        return true;

    }

    public int isBalancedd(TreeNode root){

        if(root==null)
            return 0;

        if(root.left == null && root.right==null)
            return 1;

        int left = 0, right=0;

        left = isBalancedd(root.left);

        right = isBalancedd(root.right);

        int diff = Math.abs(left-right);

        if(diff>1 || left == Integer.MAX_VALUE || right == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;


        return Math.max(left,right)+1;



    }
}