package easy.Trees;


class MinimumDepth {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        minDepth(root,1);
        return min;
    }

    public void minDepth(TreeNode root, int depth){
        if(root.left==null && root.right==null){
            min = Math.min(min, depth);
        }

        if(root.left!=null)
            minDepth(root.left,depth+1);
        if(root.right!=null)
            minDepth(root.right,depth+1);
    }
}