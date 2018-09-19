package medium.Backtracking;

class Combinations {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        backtrack(result,tempList, candidates, target,target,0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int k,int start){
        if(k<0)
            return;
        if(k==0)
            result.add(new ArrayList<Integer>(tempList));
        for(int i=start;i<candidates.length;i++){
            tempList.add(candidates[i]);
            backtrack(result,tempList,candidates,target,k-candidates[i],i);
            tempList.remove(tempList.size()-1);
        }
    }
}