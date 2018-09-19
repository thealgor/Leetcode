package hard.LinkedList;

class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head, tempHead = head, prev=null, result=null, resultHead=head;
        boolean resultHeadFound = false;

        while(curr!=null){
            int count = k;
            while(curr!=null && count!=0){
                curr=curr.next;
                count--;
            }

            if(count==0) {
                if(!resultHeadFound){
                    resultHead = reverse(tempHead,k);//3
                    result = resultHead;
                    resultHeadFound = true;
                }
                else{
                    result = reverse(tempHead,k);
                }
                tempHead.next = curr;
                if(prev!=null)
                    prev.next=result;
                prev = tempHead;
                tempHead = curr;

                //System.out.println(tempHead.val);
            }
        }

        return resultHead;

    }

    public ListNode reverse(ListNode head, int k){

        ListNode curr = null;
        while(k!=0&&head!=null){
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
            k--;
        }

        return curr;
    }
}