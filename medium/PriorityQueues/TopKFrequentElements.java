package medium.PriorityQueues;

class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<Map.Entry<Integer,Integer>>((i1, i2) -> -Integer.compare(i1.getValue(),i2.getValue()));

        Map<Integer,Integer> numbers = new HashMap<Integer,Integer>();

        for(int n: nums){
            numbers.putIfAbsent(n,1);
            numbers.put(n,numbers.get(n)+1);
        }

        pq.addAll(numbers.entrySet()); //O(N)

        List<Integer> result = new ArrayList<Integer>();

        while(k!=0 && !pq.isEmpty()){
            Map.Entry<Integer,Integer> entry = pq.poll();
            result.add(entry.getKey());
            k--;
        }

        return result;

    }
}


//Buckts are frequencies. and come from end and add it to the list
class SolutionUsingBucketSort {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // freq map
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        // bucket sort on freq
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 0; i < bucket.length; i++) bucket[i] = new ArrayList();
        for (int key : freq.keySet()) {
            bucket[freq.get(key)].add(key);
        }
        // gather result
        List<Integer> res = new ArrayList();
        for (int i = bucket.length - 1; i >= 0; i--) {
            res.addAll(bucket[i]);
            if (res.size() >= k) break;
        }
        return res;
    }
}
