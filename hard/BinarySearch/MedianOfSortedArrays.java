package hard.BinarySearch;

/**
 * Got the definition of median wrong. for even numbers, 12, arr[5]+arr[6]/2. For odd it is just arr[5]
 * lengths vs indices.
 * When to add trueCount before or after?
 * Your solution is not O(log(m+n)) it is just O(m+n)
 */

class Solution {
        //logarithmic solution
        public double findMedianSortedArrays1(int input1[], int input2[]) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
    
    
    
    
    public double findMedianSortedArraysMPlusN(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;

        int totalLength = l1+l2;


        int median1 = (l1+l2)/2;
        int median2 = -1;

        if(totalLength%2==0){
            median1 = median1;
            median2 = median1 - 1;
        }

        double result = 0;


        int i=0, j=0;
        int trueCount = 0;
        int possibleResult = -1;

        while(i!=nums1.length && j!=nums2.length){
            System.out.println("one");
            if(nums1[i]>nums2[j]){
                if(trueCount == median1 || trueCount==median2)
                    result += nums2[j];
                trueCount++;
                j++;
            }
            else{

                if(trueCount == median1 || trueCount == median2)
                    result += nums1[i];
                trueCount++;
                i++;
            }
        }

        if(i==nums1.length){
            while(j!=nums2.length){
                if(trueCount == median1 || trueCount == median2)
                    result += nums2[j];
                trueCount++;
                j++;
            }
            System.out.println("result: "+result);

        }
        else if(j==nums2.length){
            while(i!=nums1.length){
                if(trueCount == median1 || trueCount == median2)
                    result += nums1[i];
                trueCount++;
                i++;
            }
        }


        if(median2!=-1)
            result /= 2;

        return result;

    }
}
