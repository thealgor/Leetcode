package medium.Trees;


class BinaryTreeInOrderTraversal {

    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return result;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;

        }

        return result;


    }


    public List<Integer> inorderTraversalRecursive(TreeNode root){
        if(root!=null){
            inorderTraversal(root.left);
            result.add(root.val);
            System.out.println(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }



}

