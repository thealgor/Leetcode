import java.io.*;
import java.util.*;

class TwoSumDuplicates{

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // your code goes here
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

//        for(int i=0;i<arr.length;i++){
//            if(!map.containsKey(arr[i])){
//                map.put(arr[i],i);
//            }
//        }

        int[] res = new int[]{-1,-1};


        for(int i=0;i<arr.length;i++){
            int check = limit - arr[i];

            if(!map.containsKey(check)){
                map.put(arr[i],i);
            }
            else{
                res[0]=i;
                res[1]=map.get(check);
            }
        }

        return new int[]{};

    }

    public static void main(String[] args) {

        int[] arr = {4,3,6,2,8 10, 15, 16};
        int  lim = 21;

        int[] res = getIndicesOfItemWeights(arr,lim);

        for(int i=0;i<res.length;i++)
            System.out.println(res[i]);


    }

}

//map

//[4,4] 8 map {}
//        i = 0 , 8-4 does not exist, a[i] = {4(0)}
//        i = 1, 8 - 4 exist return [i,get(4)]
//
//
//        {4,3,6,2,5, 10, 15, 16}
//
//        8
//
//        {4(0),3(1),6(2),2()
//
//        [3,2]
//
//        [4,1]
//
////[],0

//[Integer.MAX_VALUE,INTEGER.MIN_VALUE] limit =0





//[4,3, 6,8, 5, 15, 16]
//key, ArrayList<>
////arrelment, indexes


//12a