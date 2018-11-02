class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i= a.length()-1, j=b.length()-1;
        int carry = 0;
        while(i>=0 || j>=0){
            int sum = carry;
            int left = (i>=0)?a.charAt(i)-'0':0;
            int right = (j>=0)?b.charAt(j)-'0':0;
            sum+=left+right;
            sb.append(sum%2);
            carry=sum/2;
            i--;
            j--;
        }
        if(carry==1) sb.append('1');
        return new String(sb.reverse());
    }


    public String addBinaryBadSolution(String a, String b) {
        int carry = 0;
        int i=a.length()-1,j=b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 && j>=0){
            boolean isLeftOne = a.charAt(i)=='1';
            boolean isRightOne = b.charAt(j)=='1';

            if(isLeftOne && isRightOne&&carry==1){
                sb.append(1);
                carry=1;
            }
            else if(((isLeftOne||isRightOne)&&carry==1) || (isLeftOne && isRightOne&&carry==0)){
                sb.append(0);
                carry=1;
            }
            else if(((!isLeftOne && !isRightOne && carry==1))|| ((isLeftOne || isRightOne)&&carry==0)){
                sb.append(1);
                carry=0;
            }
            else{
                sb.append(0);
                carry=0;
            }
            i--;
            j--;
        }

        while(i>=0){
            boolean isOne = a.charAt(i)=='1';
            if(isOne&&carry==1){
                sb.append('0');
                carry=1;
            }
            else if((isOne && carry==0)|| (carry==1 && !isOne)) {
                sb.append('1');
                carry=0;
            }
            else{
                sb.append('0');
                carry=0;
            }
            i--;
        }

        while(j>=0){
            boolean isOne = b.charAt(j)=='1';
            if(isOne&&carry==1){
                sb.append('0');
                carry=1;
            }
            else if((isOne && carry==0)|| (carry==1 && !isOne)) {
                sb.append('1');
                carry=0;
            }
            else{
                sb.append('0');
                carry=0;
            }
            j--;
        }

        if(carry==1){
            sb.append('1');
        }

        return new String(sb.reverse());
    }
}