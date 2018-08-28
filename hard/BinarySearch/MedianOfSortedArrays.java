package BinarySearch;

/**
 * Got the definition of median wrong. for even numbers, 12, arr[5]+arr[6]/2. For odd it is just arr[5]
 * lengths vs indices.
 * When to add trueCount before or after?
 * Your solution is not O(log(m+n)) it is just O(m+n)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

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