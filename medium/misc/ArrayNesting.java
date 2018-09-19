package medium.misc;

class ArrayNesting {

    //O(n) not optimal solution
    //If a number is visited before, then the set that starts at this number must be equal to previous max. So we can safely skip this number. This is because all connected numbers form a ring and no matter which number of this ring you start with total count will always be same. We are visiting each number only once.
    int max = Integer.MIN_VALUE;
    public int arrayNesting(int[] nums) {
        int l = nums.length-1;

        Set<Integer> visited = new HashSet<Integer>();
        for(int i=0;i<=l;i++){
            if(visited.contains(i))
                continue;
            int count = 1;
            int v = nesting(nums, count, i,visited);
            max=Math.max(v,max);
        }
        return max;


    }

    public int nesting(int[] nums, int count, int start, Set<Integer> visited){
        if(nums.length-1<nums[start])
            return count;

        visited.add(start);

        start = nums[start];
        if(visited.contains(start))
            return count;
        count = count+1;


        return nesting(nums,count,start,visited);

    }
}
