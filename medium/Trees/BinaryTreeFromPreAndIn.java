package Trees;

class BinaryTreeFromPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0)
            return null;
        if(preorder.length!=inorder.length)
            throw new IllegalArgumentException("Length of inorder and preorder arrays should be same");

        TreeNode result = buildTree(preorder, inorder,0, preorder.length-1, 0,inorder.length-1);
        return result;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){

        if(preStart>preEnd || inStart>inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int offset = inStart;

        for(;offset<inEnd;offset++){
            if(inorder[offset] == preorder[preStart])
                break;
        }

        root.left = buildTree(preorder, inorder, preStart+1, preStart+offset-inStart, inStart, offset-1);
        root.right = buildTree(preorder, inorder, preStart+offset-inStart+1, preEnd, offset+1, inEnd);

        return root;
    }

