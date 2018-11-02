/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //find cycle exisits and then move the node to the beginning and then check.

        ListNode fast = head;
        ListNode slow = head;
        boolean loopFound = false;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==null||slow==null)
                return null;
            if(fast==slow){
                loopFound=true;
                break;
            }
        }

        slow = head;

        while(loopFound && slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }

        if(loopFound && slow==fast)
            return slow;

        return null;

    }
}