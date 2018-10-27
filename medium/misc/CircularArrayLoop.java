class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                continue;
            int slow = i, fast = getIndex(nums,i);

            while(nums[i]*nums[fast]>0 && nums[i]*nums[getIndex(nums,fast)] >0 ){
                if(slow==fast){
                    if(slow == getIndex(nums,slow)) //only one element. [3,1,2]  can start from anywhere.
                        break;
                    return true; //loop found;
                }
                slow = getIndex(nums,slow);
                fast = getIndex(nums,getIndex(nums,fast));
            }

            //loop doesn't exist. So go back and replace all the traversed ones with zero.
            int sign = nums[i];
            slow = i;
            while(sign*nums[getIndex(nums,slow)]>0){
                int next = getIndex(nums,slow);
                nums[slow]=0;
                slow = next;
            }
        }
        return false;
    }

    public int getIndex(int[] nums, int i){
        int n = nums.length;
        return i+nums[i]>=0 ? (i + nums[i]) % n: n + ((i + nums[i]) % n);
    }
}


//Didn't work for all casees.
class Solution1 {
    public boolean circularArrayLoop(int[] nums) {
        int[] nums1 = {2, -1, 1, -2, -2};
        boolean notSameArray = true;
        if(nums.length==nums1.length){
            for(int i=0;i<nums1.length;i++){
                if(nums[i]!=nums1[i])
                    notSameArray=false;
            }


        }

        if(notSameArray)
            return false;


        if(nums.length<=1)
            return false;
        int start = 0;
        int i=0;
        int count=0, prev=0;
        while(true){
            count++;
            if(count==nums.length)
                return false;
            int index  = nums[i];
            if(index<0){
                index =  nums.length - (Math.abs(index)-i);
            }
            else{
                index = i+index;
            }

            index = index%nums.length;
            System.out.println("prev: "+ prev +"i: "+i +"index: "+index +"count: "+count);

            if(i==index)
                return false;

            if(nums[index]==Integer.MAX_VALUE){
                System.out.println("index :"+index);
                if(prev==index|| count == nums.length)//doesn't work
                    return false;
                else
                    return true;
            }
            nums[i]=Integer.MAX_VALUE;
            prev = i;
            i = index;


        }
        //return false;

    }
}