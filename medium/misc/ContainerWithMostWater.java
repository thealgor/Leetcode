package medium.misc;

class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l=0, r= height.length-1;

        int max=0;
        for(int i=0;i<height.length;i++){
            max = Math.max(max,((r-l)*Math.min(height[l],height[r])));
            if(height[l]<height[r]){
                l++;
            }
            else
                r--;
        }

        return max;
    }
}