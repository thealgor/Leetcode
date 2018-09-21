package medium.Trees;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaximumWidthOfBinaryTree {



    public int widthOfBinaryTree(TreeNode root) {
        Node n = new Node(0,0,root);
        Queue<Node> q   = new LinkedList<Node>();
        q.add(n);
        int max=0, currDepth=0, left=0;
        while(!q.isEmpty()){
            n = q.poll();
            if(n.node!=null){
                q.add(new Node(n.depth+1, n.pos*2, n.node.left));
                q.add(new Node(n.depth+1, n.pos*2+1, n.node.right));
                System.out.println("depth: "+(n.depth+1)+"post"+n.pos*2+"pos2:"+(n.pos*2+1));
                if(n.depth!=currDepth){//when you change for the first time to new depth you mark left. right - left+1;
                    System.out.println(n.depth+": "+currDepth);
                    currDepth=n.depth;
                    left = n.pos;
                }
                max = Math.max(max, n.pos-left+1);
            }
        }
        return max;

    }

    public class Node{
        int depth; //level
        int pos;
        TreeNode node;
        public Node(int depth, int pos, TreeNode node){
            this.depth = depth;
            this.pos=pos;
            this.node = node;
        }
    }


    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTreedfs(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }



    //terrible solution. Don't always think in brute force.
    public int widthOfBinaryTree1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode node = new TreeNode(Integer.MAX_VALUE);
        q.add(node);
        int max = Integer.MIN_VALUE;
        int count = 0;
        boolean firstNodeFound = false;
        boolean lastNodeFound = false;
        int tempCount = 0;
        while(!q.isEmpty()){
            node = q.poll();
            if(node!=null && node.val!=Integer.MAX_VALUE)
                count++;
            if(node==null)
                count++;

            if(node!=null && node.val!=Integer.MAX_VALUE){
                if(firstNodeFound&&!lastNodeFound){
                    lastNodeFound=true;
                    tempCount = count;
                }
                else if(!firstNodeFound){
                    firstNodeFound=true;
                    tempCount = 1;
                }
                else if(lastNodeFound){
                    tempCount=count;
                }

            }

            if(node!=null && node.val==Integer.MAX_VALUE){
                if(!firstNodeFound)
                    return max;
                max = Math.max(tempCount,max);
                count = 0;
                tempCount=0;
                node = new TreeNode(Integer.MAX_VALUE);
                if(!q.isEmpty())
                    q.add(node);
                firstNodeFound=false;
                lastNodeFound=false;
                continue;
            }

            if(node!=null && node.left!=null)
                q.add(node.left);
            else
                q.add(null);

            if(node!=null && node.right!=null)
                q.add(node.right);
            else
                q.add(null);

        }

        return max;
    }
}
