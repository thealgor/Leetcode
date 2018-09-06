package medium.misc;


class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prefix=1;
        int suffix=1;
        int[] result = new int[nums.length];

        Arrays.fill(result,1);
        for(int i=0;i<result.length;i++){
            result[i] *= prefix;
            prefix *= nums[i];
        }


        for(int i=result.length-1;i>=0;i--){
            result[i]*=suffix;
            suffix *= nums[i];
        }
        return result;
    }
}