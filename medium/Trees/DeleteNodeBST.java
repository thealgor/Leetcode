package Trees;

class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
            root.left = deleteNode(root.left,key);
        else if(root.val<key)
            root.right = deleteNode(root.right,key);
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            TreeNode t = root;
            root = min(t.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
            return root;
        }
        return root;
    }

    public TreeNode min(TreeNode root){
        while(root.left!=null)
            root = root.left;
        return root;
    }

    public TreeNode deleteMin(TreeNode root){
        if(root.left==null)
            return root.right;
        root.left = deleteMin(root.left);
        return root;
    }

}