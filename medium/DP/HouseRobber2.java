class Solution {


    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];


        return Math.max(rob(nums,1,nums.length-1), rob(nums,0,nums.length-2));
    }

    public int rob(int[] nums, int lo, int hi){
        int prevMax = 0;
        int currMax = 0;
        for (int i=lo;i<=hi;i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }



    public int rob1(int[] nums) {

        if(nums.length==0)
            return 0;
        if(nums.length<2)
            return nums[0];

        Node[] n = new Node[nums.length];
        int max = Integer.MIN_VALUE;

        n[0]= new Node(nums[0],true);
        max = Math.max(max,n[0].bestValue);
        n[1] = new Node(nums[1],false);
        max = Math.max(max,n[1].bestValue);
        for(int i=2;i<nums.length;i++){
            if(i==2){
                if(nums.length-1!=i){
                    int v1 =nums[2]+n[0].bestValue;
                    int v2 = nums[2];
                    if(v1>v2){
                        n[2] = new Node(v1,true);

                    }
                    else
                        n[2]= new Node(v2,false);
                }
                else
                    return Math.max(max,nums[2]);
            }

            else if(i==nums.length-1){
                int v1=0, v2=0;
                if(n[i-2].containsFirstNode)
                    v1=nums[i-2]+nums[i];
                else{
                    v1=n[i-2].bestValue + nums[i];
                }
                if(n[i-3].containsFirstNode){
                    if(i-3!=0)
                        v2=nums[i-3]+nums[i];
                    else
                        v2=nums[i];
                }
                else
                    v2 = n[i-3].bestValue + nums[i];

                if(v1>v2)
                    return Math.max(max,v1);
                else
                    return Math.max(max,v2);
            }
            else{
                int v1 = n[i-2].bestValue + nums[i];
                int v2 = n[i-3].bestValue + nums[i];

                if(v1>v2){
                    if(n[i-2].containsFirstNode){
                        n[i]=new Node(v1,true);
                    }
                    else
                        n[i]= new Node(v1,false);
                }
                else if(v1<v2){
                    if(n[i-3].containsFirstNode){
                        n[i]=new Node(v2,true);
                    }
                    else
                        n[i]= new Node(v2,false);
                }
                else{
                    if(!n[i-2].containsFirstNode || !n[i-3].containsFirstNode)
                        n[i]=new Node(v1,false);
                    else
                        n[i]= new Node(v1,true);
                }
            }

            max = Math.max(max,n[i].bestValue);
            System.out.println(max);
        }
        return max;
    }

    public class Node{
        int bestValue;
        boolean containsFirstNode;
        public Node(int bestValue, boolean containsFirstNode){
            this.bestValue = bestValue;
            this.containsFirstNode = containsFirstNode;
        }
    }

}