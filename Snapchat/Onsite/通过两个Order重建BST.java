应该是前序和中序吧。有follow up是验证valid的遍历。

public class Pre_In_Order_construct_Tree {
//    前序和中序的方法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null) return null;
        TreeNode root = helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        return root;
    }
//    非常漂亮,这里的想法完全正确,一次就bug free非常爽.
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preEnd < preStart || inEnd < inStart) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = findRootIndex(preorder[preStart], inorder, inStart, inEnd);
        //找长度，找长度。
        int leftLen = rootIndex-inStart;
        int rightLen = inEnd - rootIndex;
        root.left = helper(preorder, inorder, preStart+1, preStart+leftLen, inStart, rootIndex-1);
        root.right = helper(preorder, inorder, preStart+leftLen+1, preEnd, rootIndex+1, inEnd);
        return root;
    }
    private int findRootIndex(int rootValue, int[] inorder, int inStart, int inEnd){
        for (int i = inStart; i <= inEnd; i++){
            if (inorder[i] == rootValue){
                return i;
            }
        }
        return -1;
    }
}

follow up:中序遍历的验证容易，就递增就行了。
前序遍历的验证用stack压，维护一个最小值。保证左边比右边小就可以了。

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int p : preorder){
            if(p < low){
                return false;
            }
            while(!stack.isEmpty() && p > stack.peek()){
                low = stack.pop();
            }
            stack.push(p);
        }
        return true;
    }
}
