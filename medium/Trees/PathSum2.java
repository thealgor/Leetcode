package medium.Trees;


class PathSum2 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {


        result = new ArrayList<List<Integer>>();

        LinkedList<Integer> list = new LinkedList<Integer>();

        pathSum(root,sum,list);

        return result;

    }


    public void pathSum(TreeNode root, int sum, LinkedList<Integer> list){

        if(root==null)
            return;

        list.add(root.val);

        if(root.left==null && root.right == null){
            if((sum-root.val)==0){
                result.add(new ArrayList<Integer>(list));
                System.out.println("result: "+ result);
                list.remove(list.size()-1);
                return;
            }

        }

        pathSum(root.left,sum-root.val,list);
        pathSum(root.right,sum-root.val,list);
        list.remove(list.size()-1);
    }

}
