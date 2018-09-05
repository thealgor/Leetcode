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
class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<Integer>();
        if(root==null)
            return result;


        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);

        TreeNode prev = root;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr==null){
                result.add(prev.val);
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }

            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);

            prev = curr;

        }

        return result;


    }



    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}