import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    Integer next=null;
    boolean noSuchElem=false;
    Iterator<Integer> it;
    public PeekingIterator(Iterator<Integer> iterator){
        it = iterator;
        advanceIterator();
    }
    public Integer peek() {
        return next;
    }
    @Override
    public Integer next() {
        if(noSuchElem)
            throw new NoSuchElementException();
        Integer res = next;
        advanceIterator();
        return res;
    }
    @Override
    public boolean hasNext() {
        return !noSuchElem; //can't use iter.hasNext() as we are one element ahead.
    }

    public void advanceIterator(){
        if(it.hasNext())
            next = it.next();
        else
            noSuchElem=true;
    }
}





//O(n) initial time complexity not good.
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator1 implements Iterator<Integer> {
    Queue<Integer> q;
    Iterator<Integer> it;
    public PeekingIterator1(Iterator<Integer> iterator) {
        // initialize any member here.
        q = new LinkedList();
        it = iterator;
        while(iterator.hasNext()){
            q.add(it.next());
        }

        // it = q.iterator();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return q.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = q.remove();
        return result;
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}