class Solution {

    //Set<List> removes duplicates List integer values. How cool. Wasn't aware of that.
    //used variable "prev" to remove the isIncreasing method below.
    public List<List<Integer>> findSubsequencesBits(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Set<String> set = new HashSet();
        for(int i=0;i<=(1<<n);i++){
            List<Integer> subset = new ArrayList<Integer>();
            //String str = "";
            int prev=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if ((i & (1 << j)) != 0){
                    if(nums[j]<prev)
                        break;
                    //str+=nums[j];
                    subset.add(nums[j]);
                    prev=nums[j];
                }
            }
            if(subset.size()>=2){
                result.add(subset);
                //set.add(str);
            }

        }
        System.out.println(result.size());
        List<List<Integer>> list = new ArrayList<List<Integer>>(result);

        return list;
    }


    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet();
        List<Integer> subset = new ArrayList();
        dfs(nums,0,subset, Integer.MIN_VALUE,set);
        List<List<Integer>> result = new ArrayList(set);
        return result;
    }


    public void dfs(int[] nums, int start, List<Integer> subset, int prev, Set<List<Integer>> set){
        if(subset.size()>=2)
            set.add(new ArrayList<Integer>(subset));
        for(int i=start;i<nums.length;i++){
            if(prev>nums[i]) continue;
            subset.add(nums[i]);
            dfs(nums,i+1,subset,nums[i],set);
            subset.remove(subset.size()-1);
        }
    }




    //removed this code with "prev".
    // public boolean isIncreasing(List<Integer> subset){
    //     for(int i=1;i<subset.size();i++){
    //         if(subset.get(i-1)>subset.get(i))
    //             return false;
    //     }
    //     return true;
    // }
}