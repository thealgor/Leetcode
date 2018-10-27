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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        dfs(root,result,"");
        return result;
    }

    public void dfs(TreeNode root, List<String> result, String path){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            path+=root.val;
            result.add(path);
            return;
        }

        path+=root.val+"->";

        if(root.left!=null)
            dfs(root.left, result, path);
        if(root.right!=null)
            dfs(root.right,result,path);

    }
}