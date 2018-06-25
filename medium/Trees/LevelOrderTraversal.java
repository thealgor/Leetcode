package Trees;

class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node==null){
                if(queue.isEmpty()){
                    result.add(list);
                    break;
                }
                else{
                    result.add(list);
                    queue.add(null);
                    list = new ArrayList<Integer>();
                }
            }
            else{
                list.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        return result;
    }
}