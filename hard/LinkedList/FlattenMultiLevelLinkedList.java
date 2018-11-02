/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {

        if(head==null)
            return head;
        flattenList(head);
        return head;
    }


    // flattentail: flatten the node "head" and return the tail in its child (if exists)
    // the tail means the last node after flattening "head"

    // Five situations:
    // 1. null - no need to flatten, just return it
    // 2. no child, no next - no need to flatten, it is the last element, just return it
    // 3. no child, next - no need to flatten, go next
    // 4. child, no next - flatten the child and done
    // 5. child, next - flatten the child, connect it with the next, go next




    public Node flattenList(Node head){
        if(head==null)
            return head;
        else if(head.child==null){
            if(head.next==null) return head;
            else
                return flattenList(head.next); //didn't write this method
        }
        else{
            Node tail = head.next;
            Node child = head.child;
            head.child=null; //didn't do unlinking
            Node temp =  flattenList(child); //last element at the current level.
            head.next = child;
            child.prev = head;
            if(tail!=null){
                temp.next=tail;
                tail.prev=temp;
                return flattenList(tail); //didn't write this method.
            }
            return temp;
        }

    }
}