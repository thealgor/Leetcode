/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head; //remember slow and fast are heads.

        //always test against even and odd counts for this problem.
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.next.val);
        slow.next = reverse(slow.next);

        fast = slow.next;
        slow = head;

        while(fast!=null){
            if(fast.val == slow.val){
                fast = fast.next;
                slow = slow.next;
            }
            else
                return false;
        }

        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode r = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = r;
            r=curr;
            curr = temp;
        }
        return r;
    }
}