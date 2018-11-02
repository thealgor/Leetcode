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
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        diameter(root);
        return max;
    }


    public int diameter(TreeNode root){
        if(root==null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);

        max = Math.max(max,left+right);

        return Math.max(left,right)+1;


    }
}