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
        while(curr!=null){
            if(prev.val==curr.val){
                prev.next=curr.next;
                curr=curr.next;
            }
            else{
                prev=curr;
                curr = curr.next;
            }
        }
        return head;
    }
}