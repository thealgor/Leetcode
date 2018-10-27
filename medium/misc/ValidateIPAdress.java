class Solution {
    public String validIPAddress(String IP) {
        System.out.println(IP);
        if(isValidIP4(IP))
            return "IPv4";
        else if(isValidIPV6(IP))
            return "IPv6";
        else
            return "Neither";
    }

    public boolean isValidIP4(String ip){

        int countDots = 0;
        for(int i=0;i<ip.length();i++)
            if(ip.charAt(i)=='.')
                countDots++;

        String[] tokens = ip.split("\\.");

        if(countDots!=3 || tokens.length!=4)
            return false;
        for(String token: tokens){
            System.out.println(token);
            if(token.length()>3 || token.length()<1)
                return false;
            if(token.length()>1 && token.charAt(0)=='0')
                return false;

            if(!token.matches("\\d+"))
                return false;

            int v = Integer.parseInt(token);

            if(v>255 || v<0)
                return false;
        }
        return true;
    }


    public boolean isValidIPV6(String ip){
        int countColons = 0;

        for(int i=0;i<ip.length();i++)
            if(ip.charAt(i)==':')
                countColons++;

        String[] tokens = ip.split(":");
        //System.out.println(tokens.length);
        if(countColons!=7 || tokens.length!=8)
            return false;
        for(String token: tokens){
            System.out.println(token);
            if(token.length()>4|| token.length()<1)
                return false;
            for(int i=0;i<token.length();i++)
                if(token.charAt(i)>='a' && token.charAt(i)<='f' || token.charAt(i)>='A' && token.charAt(i)<='F' || token.charAt(i)>='0' && token.charAt(i)<='9'){
                    continue;
                }
                else{
                    return false;
                }
        }
        return true;
    }

}

