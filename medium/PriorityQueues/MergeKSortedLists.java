package medium.PriorityQueues;

class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        int size= lists.length;
        while(true){
            int minList = -1;
            int min = Integer.MAX_VALUE;

            int count = 0;
            for(int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    if(min>lists[i].val){
                        min=lists[i].val;
                        minList = i;
                    }

                }
                else{
                    count++;
                }
            }

            if(count==size )
                return result.next;

            curr.next = lists[minList];
            lists[minList]=lists[minList].next;
            curr = curr.next;
        }

    }
}



class MergeKSortedLists{
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0)
            return null;
        // Comparator<ListNode> comparator =
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (l1, l2) ->  Integer.compare(l1.val, l2.val));

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(int i=0;i<lists.length;i++)
            if(lists[i]!=null)
                pq.add(lists[i]);

        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
            if(tail.next!=null)
                pq.add(tail.next);
        }
        return dummy.next;

    }
}
