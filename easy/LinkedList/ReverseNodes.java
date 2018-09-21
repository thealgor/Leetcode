package easy.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseNodes {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode dummy = null;

        ListNode curr = head;
        while(curr!=null){
            ListNode temp  = curr.next;
            curr.next = dummy;
            dummy=curr;
            curr = temp;
        }

        return dummy;
    }
}
