package medium.misc;

import java.util.LinkedHashMap;
class LRUCacheDoublyLinkedList {

    private class Node{
        int key, value;
        Node next, prev;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    Map<Integer,Node> map;
    int count, capacity;
    Node head, tail;

    public LRUCache(int capacity) {
        head= new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev=head;
        map = new HashMap<Integer,Node>();
        this.capacity=capacity;
        this.count=0;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            add(n);
            return n.value;
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            map.remove(key);
            if(n.value!=value)
                n= new Node(key,value);
            add(n);
            map.put(key,n);
        }
        else{//v.imp Added remove first and map.remove next - messed all the code up :(
            if(count==capacity){
                map.remove(head.next.key);
                remove(head.next);
                Node n = new Node(key,value);
                add(n);
                map.put(key,n);

            }
            else{

                Node n = new Node(key,value);
                add(n);
                map.put(key,n);

                count++;
            }

        }
    }


    public void printNode(Node temp1, Node temp2){
        while(temp1!=null){
            System.out.print(temp1.key+ " ");
            temp1=temp1.next;
        }
        System.out.println();
        while(temp2!=null){
            System.out.print(temp2.key+ " ");
            temp2=temp2.prev;
        }
        System.out.println("");
    }

    public void add(Node n){
        Node temp = tail.prev;
        n.prev=temp;
        n.next=tail;
        temp.next=n;
        tail.prev=n;
    }


    public void remove(Node n){
        Node before = n.prev, after = n.next;
        before.next = after;
        after.prev = before;
    }
}
