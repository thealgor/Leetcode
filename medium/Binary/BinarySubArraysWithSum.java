class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        Map<Integer,Integer> map = new HashMap();
        int sum=0,result=0;
        map.put(0,1);
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            result+=map.getOrDefault(sum-S,0);
            //if(sum==S) result++;
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return result;
    }
}