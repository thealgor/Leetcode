/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next=null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(temp);
        ListNode r = merge(l1,l2);
        return r;
    }


    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr= dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                ListNode temp = l1.next;
                curr.next=l1;
                curr=l1;
                l1.next=null;
                l1=temp;
            }
            else{
                ListNode temp = l2.next;
                curr.next=l2;
                curr=l2;
                l2.next=null;
                l2=temp;
            }
        }


        while(l1!=null){
            ListNode temp = l1.next;
            curr.next=l1;
            curr=l1;
            l1.next=null;
            l1=temp;
        }

        while(l2!=null){
            ListNode temp = l2.next;
            curr.next=l2;
            curr=l2;
            l2.next=null;
            l2=temp;
        }

        return dummy.next;
    }


}