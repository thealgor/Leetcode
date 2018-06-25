package Trees;

class BinaryTreeFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length)
            throw new IllegalArgumentException("Lengths have to be same");
        if(inorder.length==0)
            return null;
        TreeNode result = buildTree(inorder, postorder, 0, postorder.length-1, 0, inorder.length-1);
        return result;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int postStart, int postEnd, int inStart, int inEnd){
        if(postStart>postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int offset = inStart;

        for(;offset<inEnd;offset++){
            if(inorder[offset]==postorder[postEnd])
                break;
        }

        root.left = buildTree(inorder, postorder,postStart, postStart+offset-inStart-1, inStart, offset-1);
        root.right = buildTree(inorder, postorder,postStart+offset-inStart, postEnd-1, offset+1, inEnd);
        return root;

    }


}