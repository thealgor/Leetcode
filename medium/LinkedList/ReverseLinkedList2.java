/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null)
            return head;

        ListNode curr = head;
        ListNode prev = null;
        for(int i=1;curr!=null && i<m;i++){
            prev =curr;
            curr = curr.next;
        }

        ListNode c = curr;

        if(c==null)
            return head;

        //reverse
        System.out.println(c.val);
        ListNode r = null;
        int i=0;
        while(curr!=null && i<=(n-m)){
            ListNode temp =curr.next;
            curr.next=r;
            r=curr;
            curr = temp;
            i++;
        }

        if(prev!=null)  //think when m==1 prev will be null. [1,2,3] 1,2 -> 2,1,3
            prev.next=r;
        c.next = curr;

        if(prev==null)
            return r;

        return head;

    }
}