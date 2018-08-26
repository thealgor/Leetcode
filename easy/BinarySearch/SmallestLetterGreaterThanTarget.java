class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int lo=0, hi=letters.length;

        while(lo<hi){
            int mid= lo + (hi-lo)/2;
            if(letters[mid]<=target){
                lo=mid+1;
            }
            else if(letters[mid]>target){
                hi=mid;
            }

        }

    /*
        if(letters[lo]>target)
            return letters[lo];
        else if(letters[lo]==target){
            if(lo<letters.length-2)
                return letters[lo+1];
            else
                return letters[0];
        }
        else if(letters[hi]==target){
            if(hi<letters.length-2)
                return letters[hi+1];
            else
                return letters[0];
        }
        else if(letters[hi]>target)
            return letters[hi];
        else
            return letters[0];

  */
        return letters[lo % letters.length];

    }
}