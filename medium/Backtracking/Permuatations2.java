package medium.Backtracking;

class Permuatations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(result,tempList,used,nums);
        return result;

    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, boolean[] used, int[] nums){
        if(tempList.size() == nums.length)
            result.add(new ArrayList<Integer>(tempList));
        else{
            for(int i=0;i<nums.length;i++){
                if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
                if(used[i]) continue;
                tempList.add(nums[i]);
                used[i]=true;
                backtrack(result,tempList,used,nums);
                tempList.remove(tempList.size()-1);
                used[i]=false;

            }
        }
    }



}