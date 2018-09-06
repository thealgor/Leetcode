package medium.Trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                result.add(curr.val);
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }
        return result;
    }
}