package medium.LinkedList;


//Correct Solution
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}


class NestedIterator1 implements Iterator<Integer> {

    List<Integer> list = new ArrayList<Integer>();
    int index = 0;
    public NestedIterator1(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    public void flatten(List<NestedInteger> nestedList){
        for(int i = 0;i<nestedList.size();i++){
            NestedInteger n = nestedList.get(i);
            if(n.isInteger()){
                list.add(n.getInteger());
            }
            else{
                List<NestedInteger> tempList = n.getList();
                flatten(tempList);
            }
        }
    }

    @Override
    public Integer next() {
        //System.out.println(list.get(index));
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }
}