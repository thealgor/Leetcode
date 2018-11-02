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

    //preorder and try to think?
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<TreeNode>();
        addSubTree(root,map,result);
        return result;
    }

    //method name can be post order
    public String addSubTree(TreeNode root, Map<String,Integer> map,List<TreeNode> result){
        if(root==null) return "#";
        String val = root.val+","+addSubTree(root.left,map,result)+","+addSubTree(root.right,map,result);
        if(map.getOrDefault(val,0)==1) result.add(root);
        map.put(val,map.getOrDefault(val,0)+1);
        return val;
    }


}