据说是原题

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        dfs(result, new ArrayList<Integer>(), nums);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> path, int[] nums){
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            dfs(result, path, nums);
            path.remove(path.size()-1);
        }
    }
}