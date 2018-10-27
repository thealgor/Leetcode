public class ZigzagIterator {
    LinkedList<Iterator> iterator;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterator = new LinkedList();
        if(!v1.isEmpty()) iterator.add(v1.iterator());
        if(!v2.isEmpty()) iterator.add(v2.iterator());
    }
    public int next() {
        Iterator<Integer> it = iterator.remove();
        int result = (Integer) it.next();
        System.out.println(result);
        if(it.hasNext()) iterator.add(it);
        return result;

    }
    public boolean hasNext() {
        return !iterator.isEmpty();
    }
}




//cannot really be extended to k list zigzag iterator.
class ZigzagIterator1 {

    List<Integer> l1, l2;
    int index1=0, index2=0;
    boolean isIndex1 = true;
    public ZigzagIterator1(List<Integer> v1, List<Integer> v2) {
        l1=v1;
        l2=v2;
    }

    public int next() {
        if(index1<l1.size() && index2<l2.size()){
            if(isIndex1){
                isIndex1=false;
                return l1.get(index1++);
            }
            if(index2<l2.size()) {
                isIndex1=true;
                return l2.get(index2++);
            }
        }

        if(index1<l1.size())
            return l1.get(index1++);

        if(index2<l2.size())
            return l2.get(index2++);
        return -1;
    }

    public boolean hasNext() {
        if(index1<l1.size() || index2<l2.size())
            return true;
        else
            return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */