package medium.misc;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        for(int k=0;k<nums.length;k++){
            int i=k+1, j=nums.length-1;
            while(i<j){
                int v = (nums[i]+nums[j]+nums[k]);

                if(v<target)
                    i++;
                else if(v>target)
                    j--;
                else
                    return v;

                int dist = Math.abs(v-target);

                if(dist<min){
                    min =dist;
                    result=v;
                }

            }

        }
        return result;

    }
}
