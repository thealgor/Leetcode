package Trees;

class SortedListToBST {

    ListNode head = null;
    public TreeNode sortedListToBST(ListNode head) {

       /* O(nlogn solution)
        if(head==null)
            return null;

        if(head.next == null)
            return new TreeNode(head.val);

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            prev = slow;
            slow=slow.next;
        }

        ListNode left = head;
        ListNode right = slow.next;

        prev.next = null;
        slow.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(left);
        root.right = sortedListToBST(right);

        return root;


    }

    */

        this.head = head;
        int length = lengthLL(head);
        TreeNode node = sortedListToBST2(0,length-1);
        return node;
    }


    public TreeNode sortedListToBST2(int start, int end){

        if(start > end)
            return null;

        int mid = start + (end - start)/2;

        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode parent = new TreeNode(head.val);
        parent.left = left;
        head = head.next;
        parent.right = sortedListToBST(mid+1, end);
        return parent;

    }

    public int lengthLL(ListNode list){
        int count = 0;
        while(list!=null){
            list = list.next;
            count++;
        }
        return count;
    }

}