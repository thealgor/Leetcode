class Solution {
    public boolean checkSubarraySumBetterBruteForce(int[] nums, int k) {
        if(nums.length==0 || nums==null)
            return false;

        for(int i=0;i<nums.length;i++){
            int sum =nums[i];
            //if(sum==k) return true;
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];

                if(k!=0 && sum%k==0)
                    return true;

                if(k==0 && sum==0)
                    return true;

            }
        }
        return false;
    }


    /**
     * This is one of those magics of remainder theorem :)

     (a+(n*x))%x is same as (a%x)

     For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the remainders are [5,1,1,5,0]. We got remainder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number which is multiple of the k. Hope this clarifies your doubt :)
     */


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
            if(k!=0)
                sum=sum%k;
            Integer prev = map.get(sum);
            System.out.println(prev);
            if(prev!=null){
                if(i-prev>1) return true;
            }
            else map.put(sum,i);

        }
        return false;

    }

}

