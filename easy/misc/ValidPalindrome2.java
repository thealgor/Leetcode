class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                String s1 = s.substring(0,i)+s.substring(i+1,n);
                System.out.println(s1);
                String s2 = s.substring(0,n-i-1)+s.substring(n-i,n);
                System.out.println(s2);
                return isValid(s1) || isValid(s2);
            }
        }
        return true; //if already palindrome removing the centre element makes it palindrome.
    }

    public boolean isValid(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}