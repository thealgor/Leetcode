package LinkedList;

class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode small = null;
        ListNode large = null;
        int len1 = length(l1);
        int len2 = length(l2);
        small = len1>len2? l2: l1;
        large = len1> len2? l1: l2;

        ListNode lc = large;
        ListNode sc = small;
        ListNode result = new ListNode(-1);
        ListNode rc = result;
        int carry = 0;

        while(lc!=null&sc!=null){
            int val =  carry+lc.val+sc.val;
            carry=0;
            int newNodeVal = val;
            if(val>=10){
                carry = 1;
                newNodeVal = val%10;
            }
            rc.next = new ListNode(newNodeVal);
            rc = rc.next;
            lc = lc.next;
            sc = sc.next;
        }
        while(lc!=null){
            int val =  carry+lc.val;
            carry=0;
            int newNodeVal = val;
            if(val>=10){
                carry = 1;
                newNodeVal = val%10;
            }
            rc.next = new ListNode(newNodeVal);

            lc = lc.next;
            rc=rc.next;
        }


        if(carry!=0){
            rc.next = new ListNode(1);
            System.out.println("ThirdLoop Loop "+ 1+" "+carry);
        }

        return result.next;
    }

    public int length(ListNode node){
        ListNode current = node;
        int count = 0;
        while(current!=null){
            current = current.next;
            count++;
        }
        return count;
    }

    public void printLL(ListNode node){
        while(node!=null){
            System.out.println(node.val+"-->");
            node = node.next;
        }
    }
}
