//BetterSolution
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         int lo = 0, hi = arr.length - k;
         while (lo < hi) {
         int mid = (lo + hi) / 2;
         if (x - arr[mid] > arr[mid+k] - x)
            lo = mid + 1;
         else
            hi = mid;
     }
        
     List<Integer> result = new ArrayList();
     for(int i=lo;i<lo+k;i++) 
        result.add(arr[i]);
     return result;
    }
}





class Solution1{
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int res = findClosestElement(arr,x);
        List<Integer> solution = findTheResult(arr, res, k, x);
        Collections.sort(solution);
        return solution;
    }

    public List<Integer> findTheResult(int[] arr, int res, int k, int x){
        List<Integer> solution = new ArrayList<Integer>();
        int left = res-1;
        int right = res+1;
        solution.add(arr[res]);
        k--;
        while(k!=0){
            while(left==-1 & k!=0){
                solution.add(arr[right]);
                right++;
                k--;
            }

            while(right == arr.length & k!=0){
                solution.add(arr[left]);
                left--;
                k--;
            }

            if(k==0) break;

            int leftValue = Math.abs(arr[left]-x);
            int rightValue = Math.abs(arr[right]-x);

            if(leftValue<=rightValue){
                solution.add(arr[left]);
                left--;
            }
            else{
                solution.add(arr[right]);
                right++;
            }

            k--;
        }
        return solution;

    }




    public int findClosestElement(int[] arr, int x){
        int bestDifference = Integer.MAX_VALUE;
        int l=0, h=arr.length;
        int res = -1;

        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==x)
                return mid;
            int diff = Math.abs(arr[mid]-x);
            if(arr[mid]>x){
                h=mid-1;
                if(diff<bestDifference){
                    bestDifference = diff;
                    res=mid;
                }
            }
            else{
                l=mid+1;
                if(diff<bestDifference){
                    bestDifference = diff;
                    res=mid;
                }
            }
        }
        return res;

    }


}
