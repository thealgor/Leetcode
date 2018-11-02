import java.math.BigInteger;


class Solution {

    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for(int i=1;i<=n/2;i++){
            if(num.charAt(0)=='0'&&i>1) return false; //didn't think about this condition as well.
            BigInteger x1 = new BigInteger(num.substring(0,i));
            for(int j=1;Math.max(i,j)<=n-i-j;j++){
                if(num.charAt(i)=='0'&&j>1) break;
                BigInteger x2 = new BigInteger(num.substring(i,i+j));//Didn't think about BigInteger or long.
                if(isValid(x1,x2,i+j,num)) return true;
            }
        }
        return false;
    }


    public boolean isValid(BigInteger x1, BigInteger x2, int start, String num){
        if(start==num.length()) return true; //not very confident about equals to nums.length() or what.
        x2=x2.add(x1); //already summed value
        x1=x2.subtract(x1);//x1 is the old x2
        String sum = x2.toString();
        return num.startsWith(sum,start) && isValid(x1,x2,(start+sum.length()), num);

    }


    //having n3 and n4 was messier. Instead could have used startsWith
    public boolean isAdditiveNumbers(String num) {
        return isAdditiveNumber(num, 0, 0);
    }

    public boolean isAdditiveNumber(String num, int index, int count){
        System.out.println("index:"+index);
        if(count<2 && index>=(num.length()-1))
            return false;

        if(count>=2 && index>=num.length()-1)
            return true;


        boolean result1=false, result2=false;

        System.out.println((index+1)+","+(index+2)+","+num.length());
        for(int i=index+1;i<num.length();i++){
            for(int j=i+1;(j+1)<=num.length();j++){

                System.out.println(index+":"+i);
                int n1 = Integer.parseInt(num.substring(index,i));
                int n2 = Integer.parseInt(num.substring(i,j));
                int n3 = -1;
                if(j+Math.max((i-index),(j-i))+1<num.length())
                    n3=Integer.parseInt(num.substring(j,(j+Math.max((i-index),(j-i))+1)));
                int n4 = Integer.parseInt(num.substring(j,j+Math.max((i-index),(j-i))));

                System.out.println(n1+","+n2+","+n3+","+n4);

                if(n1+n2==n3){
                    System.out.println("h1");
                    result1= isAdditiveNumber(num, i+j+1,count+1);
                }

                if(n1+n2==n4){
                    System.out.println("h2");
                    System.out.println(i+j);
                    result2=  isAdditiveNumber(num,j+Math.max((i-index),(j-i)),count+1);
                    System.out.println(result2);
                }

                if(result1||result2)
                    return true;

            }
        }
        return result1||result2;
    }
}