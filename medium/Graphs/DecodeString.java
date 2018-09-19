package medium.Graphs;

class DecodeString {

    int index = 0;
    public String decodeString(String s) {

        String result =  decode(s);
        return result;
    }


    public String decode(String s){
        String result = "";
        while(index<s.length()&&s.charAt(index)!=']'){
            if(!Character.isDigit(s.charAt(index)))
                result += s.charAt(index++);
            else{
                int n = 0;
                while(index<s.length()&&Character.isDigit(s.charAt(index))){
                    n=n*10+(int)Character.getNumericValue(s.charAt(index++));
                }

                //System.out.println(n);
                index++; //[
                String t = decode(s);
                //System.out.println(t);
                index++; //]

                while(--n>=0){
                    result +=t;
                }


            }

        }
        return result;
    }
}
