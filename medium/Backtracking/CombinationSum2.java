package medium.Backtracking;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(result,tempList, candidates, target,target,0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int k,int start){
        if(k<0)
            return;
        if(k==0)
            result.add(new ArrayList<Integer>(tempList));
        for(int i=start;i<candidates.length;i++){
            if(i>start&&candidates[i-1]==candidates[i]) continue;
            tempList.add(candidates[i]);
            backtrack(result,tempList,candidates,target,k-candidates[i],i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}