package medium.Trees;

class SumRootToLeafNumbers {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        List<String> results = new ArrayList<String>();
        int result = 0;
        sum(root,"",results);
        for(String r: results){
            if(r.equals("")) continue;
            result += Integer.parseInt(r);
        }

        return result;
    }

    public void sum(TreeNode root, String result, List<String> results){
        if(root==null)
            return;

        if(root.left==null && root.right==null){
            result += Integer.toString(root.val);
            results.add(new String(result));
            return;
        }

        result+= Integer.toString(root.val);
        sum(root.left,result,results);
        sum(root.right,result,results);
    }


    public int sumNumbersShortSolution(TreeNode root) {
        return sumShort(root, 0);
    }

    public int sumShort(TreeNode n, int s){
        if (n == null) return 0;
        if (n.right == null && n.left == null) return s*10 + n.val;
        return sumShort(n.left, s*10 + n.val) + sumShort(n.right, s*10 + n.val);
    }
}