package hard.Trees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * https://www.geeksforgeeks.org/iterative-postorder-traversal-using-stack/
 */
class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode prev = null;
        stack.push(curr);

        while(!stack.isEmpty()){
            //going down

            curr = stack.peek();
            if(prev==null||prev.left==curr||prev.right==curr){
                if(curr.left!=null)
                    stack.push(curr.left);
                else if(curr.right!=null)
                    stack.push(curr.right);
                else{
                    stack.pop();
                    result.add(curr.val);
                }
            }

            //going up
            else if(curr.left==prev){
                if(curr.right!=null){
                    stack.push(curr.right);
                }
                else{//missed it first time. Important
                    stack.pop();
                    result.add(curr.val);
                }
            }
            else if(curr.right==prev){
                stack.pop();
                result.add(curr.val);
            }

            prev=curr;


        }

        return result;


    }
}