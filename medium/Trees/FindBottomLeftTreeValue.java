package medium.Trees;

class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int[] result = new int[2];
        Arrays.fill(result,-1);
        dfs(root,0,result);
        return result[1];
    }

    public void dfs(TreeNode root, int depth,int[] result){

        if(root==null)
            return;

        if(depth>result[0]){
            result[1]=root.val;
            result[0]=depth;
        }


        dfs(root.left,depth+1,result);
        dfs(root.right, depth+1,result);


    }



}