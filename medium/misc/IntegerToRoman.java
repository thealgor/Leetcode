package medium.misc;

public class IntegerToRoman {
    
  public String intToRoman(int num) {

    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<values.length;i++) {
        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();
  }
    
    
    
    Map<Integer,String> map;
    public void initializeMap(){
        map  = new HashMap<Integer,String>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5, "V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
    }

    public String intToRomanLongSolution(int num) {
        String result = "";
        initializeMap();
        int i=0;
        StringBuilder sb = new StringBuilder();
        while(num!=0 && i<=3){

            int n = num%10 * (int)Math.pow(10,i);
            num = num/10;

            if(i==0)
                sb.append(getRoman(n,1,"I"));
            if(i==1)
                sb.append(getRoman(n,10,"X"));
            if(i==2)
                sb.append(getRoman(n,100,"C"));
            if(i==3)
                sb.append(getRoman(n,1000,"M"));

            i++;

        }

        return new String(sb.reverse());

    }

    public String getRoman(int n, int v, String s){
        StringBuilder temp = new StringBuilder();
        while(n!=0){
            if(map.containsKey(n)){
                StringBuilder sb = new StringBuilder();
                sb=sb.append(map.get(n));
                temp.append(sb.reverse());
                n=0;
            }
            else{
                temp.append(s);
                n -= v;
            }

            if(n==0){
                //temp = temp.reverse();
                break;
            }

        }
        return new String(temp);

    }


    public  String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

}
