/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution{
    List<Integer> result = new ArrayList();
    int currVal = 0, currCount=0, maxCount=0;
    public int[] findMode(TreeNode root) {
        inorder(root, 0);
        currVal=0; currCount=0;
        inorder(root,1);
        return result.stream().mapToInt(x->x).toArray();
    }

    public void handleValue(int val, int iter){
        if(val!=currVal){
            currVal=val;
            currCount=1;
        }
        else
            currCount++;

        if(currCount>maxCount)
            maxCount=currCount;
        if(iter==1 && maxCount==currCount){
            result.add(currVal);
        }
    }

    public void inorder(TreeNode root, int i){
        if(root==null)
            return;
        inorder(root.left,i);
        handleValue(root.val,i);
        inorder(root.right,i);
    }
}


class Solution1{
    Map<Integer,Integer> map = new HashMap();
    public int[] findMode(TreeNode root) {
        mode(root);
        int max=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            max=Math.max(entry.getValue(),max);
        }
        List<Integer> res = new ArrayList();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==max) res.add(entry.getKey());
        }

        return res.stream().mapToInt(x->x).toArray();
    }

    public void mode(TreeNode root){
        if(root==null)
            return;
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        mode(root.left);
        mode(root.right);
    }
}