/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
            return head;
        //ListNode tmp = nextHead.next;
        ListNode nextHead = head.next;
        ListNode tmp = nextHead.next;
        nextHead.next = head;
        head.next = swapPairs(tmp);
        return nextHead;
    }
}