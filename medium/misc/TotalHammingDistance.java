class TotalHammingDistance {
    /*
For each bit position 1-32 in a 32-bit integer, we count the number of integers in the array which have that bit set. Then, if there are n integers in the array and k of them have a particular bit set and (n-k) do not, then that bit contributes k*(n-k) hamming distance to the total.*/

    public int totalHammingDistance(int[] nums) {
        int total=0;
        for(int i=0;i<32;i++){
            int bitCount=0;
            for(int j=0;j<nums.length;j++){
                bitCount+=((nums[j]>>i) & 1);
            }
            total += bitCount*(nums.length-bitCount);
        }
        return total;
    }


    //O(n2) TLE
    public int totalHammingDistance1(int[] nums) {
        int n=nums.length;
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                total+=hammingDistance(nums[i],nums[j]);
            }
        }
        return total;
    }

    public int hammingDistance(int x, int y) {
        int v = x^y;
        int count=0;
        while(v>0){
            v&=v-1;
            count++;
        }
        return count;
    }
}