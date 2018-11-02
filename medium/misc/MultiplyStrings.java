class Solution {


    public String multiply(String num1, String num2) {
        int m = num1.length(), n= num2.length();
        int[] pos = new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int p1 = i+j, p2 = i+j+1;
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                int mul = n1*n2;
                int sum = mul+ pos[p2];
                pos[p1] += sum/10;
                pos[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p: pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();

    }






    //couldn't solve. Try explaining the solution before actually coding it up. Try to solve it by hand before attempting solution. Did addition
    public String multiplyyy(String num1, String num2) {

        if(num2==null  || num2.isEmpty())
            return num1;
        else if(num1==null || num1.isEmpty())
            return num2;

        int i=num1.length()-1, j=num2.length()-1, carry=0, rem=0;
        StringBuffer result = new StringBuffer();

        int n1=1, n2=1, m;
        for(int k=num2.length()-1;k>=0;k--){
            n2= Character.getNumericValue(num2.charAt(k));
            for(int l=num1.length()-1;l>=0;l--){
                n1 =  Character.getNumericValue(num1.charAt(l));
                m = n1 * n2 + carry;
                carry = m/10;
                rem = m%10;
                System.out.println(n1+""+n2+""+m+""+carry+""+rem);
                result.append(rem);
            }
        }


        while(i>=0 || j>=0){

            if(i>=0)
                n1 =  Character.getNumericValue(num1.charAt(i));
            if(j>=0)
                n2 = Character.getNumericValue(num2.charAt(j));

            m = n1 * n2 + carry;
            carry = m/10;
            rem = m%10;
            System.out.println(n1+""+n2+""+m+""+carry+""+rem);
            result.append(rem);
            i--;
            j--;
        }

        if(carry!=0)
            result.append(carry);

        return new String(result.reverse());

    }
}