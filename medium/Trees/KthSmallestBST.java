package Trees;

class KthSmallestBST {

    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;

        int resultLeft = kthSmallest(root.left, k);
        count++;
        if(count==k)
            return root.val;
        int resultRight = kthSmallest(root.right, k);

        return (resultLeft==-1)?resultRight: resultLeft;

    }

}