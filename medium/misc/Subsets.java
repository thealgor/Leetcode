package medium.misc;

class Subsets {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        int m = nums.length;

        List<Integer> subset = new ArrayList<Integer>();
        dfs(nums,0,subset);
        return result;
    }


    //[]
    //[1]
    //[1,2]
    //[1,3]
    //[1,2,3]
    //[2]
    //[2,3]
    //[3]
    private void dfs(int[] nums, int start, List<Integer> subset){
        result.add(new ArrayList<Integer>(subset));
        for(int i=start;i<nums.length;i++){
            subset.add(nums[i]);
            dfs(nums, i+1, subset);
            subset.remove(subset.size()-1);
        }
    }


    //
    public List<List<Integer>> subsetsBFS(int[] nums) {
        // List vs ArrayList （google）
        List<List<Integer>> results = new LinkedList<>();

        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);

        // BFS
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new LinkedList<Integer>());

        while (!queue.isEmpty()) {
            List<Integer> subset = queue.poll();
            results.add(subset);

            for (int i = 0; i < nums.length; i++) {
                if (subset.size() == 0 || subset.get(subset.size() - 1) < nums[i]) {
                    List<Integer> nextSubset = new LinkedList<Integer>(subset);
                    nextSubset.add(nums[i]);
                    queue.offer(nextSubset);
                }
            }
        }

        return results;
    }






    public List<List<Integer>> subsetsBitManipulation(int[] nums) {
        int m = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0;i<(1<<m);i++){
            List<Integer> subset = new ArrayList<Integer>();
            for(int j=0;j<m;j++){
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }

            }
            result.add(subset);
        }
        return result;
    }
}