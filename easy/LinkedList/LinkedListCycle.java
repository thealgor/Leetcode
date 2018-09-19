package easy.LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;

        while(slow!=null && fast!=null && fast!=slow){
            if(fast.next!=null)
                fast=fast.next.next;
            else
                fast=fast.next;
            slow = slow.next;
        }

        return fast==slow;

    }
}