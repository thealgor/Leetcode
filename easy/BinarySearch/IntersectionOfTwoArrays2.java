/*
* What if elements of nums2 are stored on disk, and the memory is
limited such that you cannot load all elements into the memory at
once?

If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.

If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.
*
*/



class Solution {

  /*
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;

        List<Integer> result = new ArrayList<Integer>();

        while(i!=nums1.length && j!=nums2.length){
            if(nums1[i]>nums2[j]){
                j++;
                continue;
            }
            else if(nums1[i]==nums2[j]){
                result.add(nums1[i]);
                i++;
                j++;
                continue;
            }
            else{
                i++;
                continue;
            }
        }

        int[] res = new int[result.size()];
        int k = 0;
        for(int v: result){
            res[k]=v;
            k++;
        }
        return res;

    }

    */

      //mroe things to learn

      public int[] intersect(int[] nums1, int[] nums2) {
        // freq count for nums1
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        // collect result
        ArrayList<Integer> result = new ArrayList();
        for (int num: nums2) {
            if (map.containsKey(num)){
                result.add(num);
                map.put(num, map.get(num) - 1);
                map.remove(num, 0);
            }
        }
       // convert result
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++) {
           r[i] = result.get(i);
       }
       return r;
    }

}