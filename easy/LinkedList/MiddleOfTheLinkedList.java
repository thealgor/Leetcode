/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {

        if(head==null || head.next==null)
            return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }

        if(fast==null)
            return slow;
        if(fast.next==null)
            return slow.next;

        return slow;
    }
}