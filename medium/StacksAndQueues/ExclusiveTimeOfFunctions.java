
//start and end are more like opening and closing brackets in stack
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        int pre=0;
        for(String log: logs){
            String[] arr = log.split(":");
            if(arr[1].equals("start")){
                if(!st.isEmpty())
                    result[st.peek()] += Integer.parseInt(arr[2]) - pre;
                st.push(Integer.parseInt(arr[0]));
                pre = Integer.parseInt(arr[2]);
            }
            else{
                result[st.pop()] += Integer.parseInt(arr[2])-pre+1;
                pre = Integer.parseInt(arr[2])+1; //missed out on the +1 at the end
            }
        }
        return result;

    }
}