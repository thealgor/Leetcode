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

    //simpler solution
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }


    public List<List<Integer>> levelOrderBottommysol(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root ==null)
            return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        Stack<List<Integer>> stack = new Stack();
        List<Integer> list = new ArrayList();
        list.add(root.val);
        List<Integer> newList = new ArrayList();
        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node==null){
                stack.add(list);
                list = newList;
                newList =new ArrayList();
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }

            if(node.left!=null){
                q.add(node.left);
                newList.add(node.left.val);
            }
            if(node.right!=null){
                q.add(node.right);
                newList.add(node.right.val);
            }

        }
        System.out.println(stack);

        int size = stack.size();
        for(int i=0; i<size;i++){
            result.add(stack.pop());
        }
        return result;
    }
}