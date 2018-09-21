package easy.misc;

class MoveZeros {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0)
            return;

        int count=0;
        for(int n:nums)
            if(n==0)
                count++;


        int i=0,j=0;
        while(j<nums.length){
            if(nums[j]!=0){
                nums[i++]=nums[j++];
            }
            else
                j++;
        }

        for(int k=nums.length-count;k<nums.length;k++)
            nums[k]=0;

    }

    public void moveZeroesBetterSolution(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }


}
