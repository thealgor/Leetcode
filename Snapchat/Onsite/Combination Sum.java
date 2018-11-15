给{2,3,6,7} target是7。返回[2,2,3]和[7]。

class Solution{
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		dfs(candidates, target, 0, new ArrayList<Integer>(), result);
		return result;
	}
	public void dfs(int[] candidates, int target, int start, List<Integer> record, List<List<Integer>> result){
		if (target == 0) {
			result.add(new ArrayList<Integer>(record));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[start] > target) {
				break;
			}
			record.add(candidates[i]);
			dfs(candidates, target - candidates[i], i, record, result);
			record.remove(record.size()-1);
		}
	}
}