package easy.misc;

class RangeSumImmutable {

    int[] nums;
    public RangeSumImmutable(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {

        if(!(i<=j&& i>=0 && i<nums.length&&j<nums.length))
            return -1;

        int sum = 0;
        for(int k=i;k<=j;k++){
            //System.out.println(nums[k]);
            sum+=nums[k];
        }
        return sum;
    }
}