package medium.Trees;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    //preorder with nulls
    public final static String SPLITTER=",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }


    public void preOrder(TreeNode root, StringBuilder sb){
        if(root==null)
            sb.append("NULL").append(SPLITTER);
        else{
            sb.append(root.val).append(SPLITTER);
            preOrder(root.left,sb);
            preOrder(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(SPLITTER)));
        return buildTree(q);
    }

    public TreeNode buildTree(Queue<String> q){
        String str = q.poll();
        if(str.equals("NULL"))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));