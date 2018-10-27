/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int len = 0;
    public void reorderList(ListNode head) {

        if(head==null || head.next==null)
            return;

        ListNode slow= head;
        ListNode fast = head.next;
        //find middle using slow fast pointers
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        slow.next = reverse(slow.next);

        ListNode p2 = slow.next;
        ListNode p1 = head;

        while(p1!=null) {
            System.out.print(p1.val+"->");
            p1=p1.next;
        }

        //my logic for the below code was wrong copy pasted this from another guy.
        p1=head;
        p2=slow.next;
        while(p1!=slow){
            slow.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=slow.next;
        }

    }

    public ListNode reverse(ListNode head){
        ListNode r=null;
        ListNode curr=head;
        while(curr!=null){ //wrote curr.next unfortunately you cannot even reverse a LL.
            ListNode temp = curr.next;
            curr.next=r;
            r=curr;
            curr=temp;
            len++;
        }
        return r;
    }
}