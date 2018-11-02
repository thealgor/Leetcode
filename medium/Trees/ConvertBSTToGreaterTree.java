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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root ==null)
            return null;
        convertBST(root.right);
        root.val+=sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }


//     public TreeNode convertBST(TreeNode root, int max){
//         if(root==null)
//             return root;
//         if(root.left==null && root.right==null)


//          TreeNode right = convertBST(root.right);

//          if(right!=null){
//             root.val += right.val;
//             max = Math.max(root.val,max);
//          }
//          if(root.left!=null)
//              root.left.val+=addLeft;
//          TreeNode left = convertBST(root.left);

//         return root;
//     }





}