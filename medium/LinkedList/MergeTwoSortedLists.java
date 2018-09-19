package medium.LinkedList;

class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                curr.next = l2;
                curr = l2;
                l2=l2.next;
            }
            else{
                curr.next = l1;
                curr = l1;
                l1=l1.next;
            }

        }

        if(l1!=null)
            curr.next=l1;

        else if(l2!=null)
            curr.next=l2;

        return result.next;

    }
}