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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(list,root,0);
        return list;
    }

    public void dfs(List<Integer> list, TreeNode root, int depth){
        if(root==null)
            return;

        if(list.size()-1<depth)
            list.add(depth, root.val);
        else{
            int curMax = list.get(depth);
            curMax = Math.max(curMax, root.val);
            list.set(depth,curMax);
        }

        if(root.left!=null)
            dfs(list, root.left, depth+1);

        if(root.right!=null)
            dfs(list,root.right,depth+1);

    }

    //BFS
    public int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i=0;i<queueSize;i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        int[] resArray = new int[res.size()];
        for (int i=0;i<res.size();i++) resArray[i] = res.get(i);
        return resArray;
    }
}