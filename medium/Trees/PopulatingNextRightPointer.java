package medium.Trees;

public class PopulatingNextRightPointer {
    public void connect(TreeLinkNode root) {

        if(root==null)
            return;

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.add(root);
        q.add(null);
        List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        list.add(root);

        List<TreeLinkNode> nextList = new ArrayList<TreeLinkNode>();

        while(!q.isEmpty()){
            TreeLinkNode curr = q.remove();
            if(curr==null){
                if(!list.isEmpty()){
                    System.out.println(list);
                    for(int i=0;i<((list.size())-1);i++){
                        list.get(i).next=list.get(i+1);
                    }
                    System.out.println(list);
                    list.get(list.size()-1).next=null;
                }
                list = nextList;
                nextList = new ArrayList<TreeLinkNode>();
                if(!q.isEmpty())
                    q.add(null);
            }

            if(curr==null)
                continue;

            if(curr.left!=null){
                q.add(curr.left);
                nextList.add(curr.left);

            }

            if(curr.right!=null){
                q.add(curr.right);
                nextList.add(curr.right);
            }

        }



    }


    public void connectEasierSolution(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}