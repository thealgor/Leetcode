package medium.misc;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0 )
            return result;

        Arrays.sort(nums);

        for(int k=0;k<nums.length;k++){
            int sum = 0-nums[k];

            int i=k+1, j=nums.length-1;

            if(k>0 && nums[k-1]==nums[k]) continue;

            while(i<j){

                if(sum==nums[i]+nums[j]){
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i<j && nums[i]==nums[i+1])
                        i++;
                    while(i<j && nums[j]==nums[j-1])
                        j--;

                    i++;
                    j--;

                }
                else if(sum<nums[i]+nums[j]) j--;
                else i++;

            }



        }

        return result;


    }
}