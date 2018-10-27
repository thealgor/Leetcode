
class Solution {
    public boolean makesquare(int[] nums) {
        if(nums==null || nums.length<4)
            return false;
        int target = 0;
        for(int i:nums)
            target+=i;
        if(target%4!=0)
            return false;
        target=target/4;
        Arrays.sort(nums);
        reverse(nums);
        return dfs(nums,0,target, new int[4]);

    }

    public boolean dfs(int[] nums, int index, int target, int[] sums){
        if(sums[0]==target && sums[1]==target && sums[2]==target && sums[3]==target)
            return true;

        for(int i=0;i<4;i++){
            if(sums[i]+nums[index]>target) continue;
            sums[i]+=nums[index];
            if(dfs(nums,index+1, target, sums)) return true;
            sums[i]-=nums[index];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }
}


//[10,6,5,5,5,3,3,3,2,2,2,2] Doesn't work for this use case wher 12 can be formed with multiple elments as 3 or 4 elements.
class Solution1 {
    public boolean makesquare1(int[] nums) {
        int size = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
            size+=i;
        }
        size = size/4;
        System.out.println("size: "+size);
        int count = 0;
        for(int i: nums){
            int n1 = size - i;
            if(map.containsKey(i)){
                System.out.println("get: "+map.get(i));
                if(map.get(i)>1){
                    map.put(i, map.get(i)-1);
                }
                else
                    map.remove(i);
            }
            else
                continue;

            if(n1==0){
                count++;
                continue;
            }
            else{
                if(map.containsKey(n1)){
                    if(map.get(n1)>1){
                        map.put(n1, map.get(n1)-1);
                    }
                    else{
                        map.remove(n1);
                        System.out.println("removed i");
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
        if(count==4)
            return true;

        return false;

    }
}