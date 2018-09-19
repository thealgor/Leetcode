package medium.Trees;

//O(n2) - not acceptable :( - even though accepted :P
class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        height(root,result);
        return result;

    }

    public int height(TreeNode root, List<List<Integer>> result){
        if(root==null) return -1;
        int level = 1+Math.max(height(root.left, result), height(root.right,result));
        if(result.size()<level+1) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        return level;
    }


    public List<List<Integer>> findLeaves1(TreeNode root) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root==null)
            return results;

        while(true){
            List<Integer> list = new ArrayList<Integer>();
            if(root.left==null && root.right==null){
                list.add(root.val);
                results.add(list);
                return results;
            }

            removeLeaves(root,null,false,list);
            results.add(list);
        }

    }

    public void removeLeaves(TreeNode root, TreeNode prev, boolean isLeft, List<Integer> result){
        if(root==null)
            return;

        // System.out.println(root.val);
        if(root.left==null && root.right==null){
            if(isLeft){
                prev.left=null;
            }
            else
                prev.right=null;
            result.add(root.val);
        }

        removeLeaves(root.left,root,true,result);
        removeLeaves(root.right,root,false,result);
    }




}