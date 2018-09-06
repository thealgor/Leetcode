package medium.LinkedList;

class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        if(head.next==null)
            return null;

        ListNode curr = head;
        ListNode start = head;
        int size=0;
        for(int i=0;i<n;i++){
            if(curr!=null){
                curr = curr.next;
                size++;
            }
            else
                return null;
        }

        if(curr==null && n==size)
            return head.next;

        while(curr.next!=null){
            curr = curr.next;
            start=start.next;
        }


        if(start.next!=null){
            ListNode temp = start.next.next;
            start.next = temp;
        }
        else
            return null;

        return head;

    }
}