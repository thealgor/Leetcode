import java.io.*;
import java.util.*;

class Solution {

    static int bracketMatch(String text) {


        if(text==null)
            throw new IllegalArgumentException("Text can't be null");
        // your code goes here
        int left=0, right=0;

        for(int i=0;i<text.length();i++)}{
        if(text.charAt(i)=='(')
            left++;
        else if(text.charAt(i)==')'){
            if(left==0){
                right++;
            }
            else
                left--;
        }
    }
   return (left+right);

}

    public static void main(String[] args) {

    }

}
