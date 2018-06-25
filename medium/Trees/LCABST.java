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
class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == p || root == q)
            return root;

        if(root == null)
            return null;

        TreeNode minNode = null;
        TreeNode maxNode = null;

        if(p.val > q.val){
            minNode = q;
            maxNode = p;
        }
        else{
            minNode = p;
            maxNode = q;
        }


        if(minNode.val < root.val &&  maxNode.val > root.val)
            return root;

        TreeNode left = null;
        TreeNode right = null;

        if(minNode.val < root.val && maxNode.val < root.val)
            left = lowestCommonAncestor(root.left, p, q);

        if(minNode.val > root.val && maxNode.val > root.val)
            right = lowestCommonAncestor(root.right, p,q);

        return (left==null)? right:left;

    }
}