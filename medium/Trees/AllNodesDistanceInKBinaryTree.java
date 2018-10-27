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
    Map<TreeNode, List<TreeNode>> map = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList();
        if(root==null) return result;
        buildTree(root);
        if(!map.containsKey(target)) return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(target);
        q.add(null);
        int count=0;
        Set<TreeNode> set = new HashSet();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(K==0){
                result.add(node.val);
                return result;
            }
            if(count>=K) return result;


            // if(node!=null)
            //     System.out.println(node.val);
            if(node==null){
                count++;
                if(!q.isEmpty()) q.add(null);
                continue;
            }

            List<TreeNode> list = map.get(node);
            System.out.println("count: "+count);
            for(TreeNode n: list){
                if(set.contains(n)) continue;
                q.add(n);
                set.add(n);
                if(count+1==K){
                    if(target.equals(n)) continue;
                    result.add(n.val);
                }
            }
        }
        return result;

    }

    public void buildTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode parent = q.poll();
            map.computeIfAbsent(parent, x-> new ArrayList<TreeNode>());
            if(parent.left!=null){
                q.add(parent.left);
                map.computeIfAbsent(parent.left, x-> new ArrayList<TreeNode>());
                map.get(parent).add(parent.left);
                map.get(parent.left).add(parent);
            }

            if(parent.right!=null){
                q.add(parent.right);
                map.computeIfAbsent(parent.right, x-> new ArrayList<TreeNode>());
                map.get(parent).add(parent.right);
                map.get(parent.right).add(parent);
            }

        }

        map.forEach((k,v) -> System.out.println(k.val +": "+v));
    }
}