/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode curr = head.next, prev=head;
        ListNode dummy = new ListNode(head.val-1);
        int duplicate =head.val-1;
        ListNode r=dummy;
        while(curr!=null){
            if(prev.val==curr.val){
                duplicate = prev.val;
                prev=curr;
                curr=curr.next;
            }
            else{
                if(prev.val==duplicate){
                    prev=curr;
                    curr=curr.next;
                }
                else{
                    r.next=prev;
                    r=prev;
                    r.next=null;
                    prev=curr;
                    curr=curr.next;
                    duplicate=r.val;
                }
            }
        }
        if(curr==null && duplicate!=prev.val){
            r.next=prev;
        }

        return dummy.next;
    }
}