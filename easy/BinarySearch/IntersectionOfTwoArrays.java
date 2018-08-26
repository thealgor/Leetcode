/*
*  cannot return Integer array for int[]
*   toArray returns Object version of the primitive types.
*
*/


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();

        for(int v:nums2){
            if(!set.contains(v)){
                set.add(v);
            }
        }

        for(int v:nums1){
            if(set.contains(v))
                result.add(v);
        }

        int[] res = new int[result.size()];
        int i=0;
        for(int v: result){
            res[i]=v;
            i++;
        }
        return res;
    }
}