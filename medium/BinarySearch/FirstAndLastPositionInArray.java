package medium.BinarySearch;

/*
* conditions missed 1) [1],1
* 2) [1,4], 4
* solution was not left<right but, left<=right
* 4) When both are equal what should I pass?
*  if(nums[l]==target&&nums[r]==target){
            if(left)
                return l;
            else
                return r;
        }
*
* duplicates allowed or not, general question to ask for every array problem.
*/
class FirstAndLastPositionInArray {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r=nums.length-1;
        int res1=-1, res2=-1;

        if(r==0&&nums[r]==target){
            res1=0;
            res2=0;
        }

        while(l<=r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                res1 = binSearch(nums, l, m, target,true);
                res2 = binSearch(nums,m,r,target,false);
                break;
            }
            else if(nums[m]>target){
                r=m-1;
            }
            else
                l=m+1;
        }
        return new int[]{res1,res2};
    }

    public int binSearch(int[] nums, int l, int r,int target,boolean left){

        while(l+1<r){
            int m = l+(r-l)/2;
            if(nums[m]==target){
                if(left)
                    r=m;
                else
                    l=m;
            }
            else{
                if(left)
                    l=m;
                else
                    r=m;
            }
        }
        if(nums[l]==target&&nums[r]==target){
            if(left)
                return l;
            else
                return r;
        }

        if(nums[l]==target)
            return l;
        else
            return r;
    }

}