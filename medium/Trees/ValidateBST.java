package Trees;

class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(Integer.MAX_VALUE);
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null)
            return true;

        if(root.val >= max || root.val <= min )
            return false;

        boolean isValidLeft = isValidBST(root.left, min, root.val);
        boolean isValidRight = isValidBST(root.right,root.val, max);

        return isValidLeft && isValidRight;


    }

