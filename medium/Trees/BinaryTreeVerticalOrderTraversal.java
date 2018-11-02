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

    //more cleaner solutoin

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                min = Math.min(min, col - 1);
            }

            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }

        return res;
    }








    List<List<Integer>> list;

    public List<List<Integer>> verticalOrder1(TreeNode root) {
        int n = total(root);
        list = Arrays.asList(new ArrayList[2*n] );
        verticalOrder(root,n);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<list.size();i++){
            if(list.get(i)==null)
                continue;
            else
                result.add(list.get(i));
        }
        return result;
    }


    public void verticalOrder(TreeNode root,int n) {
        if(root==null) return;


        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(n);
        while(!q.isEmpty()){

            TreeNode node = q.poll();
            n = cols.poll();

            if(list.get(n)==null){
                list.set(n,new ArrayList());
            }

            List<Integer> l = list.get(n);
            l.add(node.val);
            list.set(n,l);

            if(node.left!=null){
                q.add(node.left);
                cols.add(n-1);
            }

            if(node.right!=null){
                q.add(node.right);
                cols.add(n+1);
            }
        }


    }

    public int total(TreeNode root){
        if(root==null)
            return 0;
        return 1+total(root.left)+total(root.right);
    }

}