class Solution {

    //time complexity O(3^4) - constant
    //Implicit Backtracking with DFS when you are not creating stringBuffer in the root method.
    public List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        if (count == 4 && idx == ip.length()) solutions.add(restored);

        for (int i=1; i<4; i++) {
            if (idx+i > ip.length()) break;
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
        }
    }



    //another solution
    public List<String> restoreIpAddressesAnother(String s) {
        List<String> res = new ArrayList<String>();
        int len = s.length();
        for(int i = 1; i<4 && i<len-2; i++){
            for(int j = i+1; j<i+4 && j<len-1; j++){
                for(int k = j+1; k<j+4 && k<len; k++){
                    String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }
    public boolean isValid(String s){
        if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
            return false;
        return true;
    }



    //My solution
    public List<String> restoreIpAddressesBacktracking(String s) {
        List<String> result = new ArrayList();
        if(s==null || s.length()<4)
            return result;
        restoreIpAddress(s,result,0,new StringBuilder(),0);
        return result;
    }

    public void restoreIpAddress(String s, List<String> result, int index, StringBuilder sb, int count){

        if(count==4&&index==s.length()){
            sb.setLength(sb.length()-1); //removing the last dot before you add to the solution
            result.add(new String(sb));
            sb.append('.');//readding the last dot.
            return;
        }

        if(count==4 && index!=s.length())
            return;

        for(int i=1;i<=3;i++){
            if((index+i)>s.length()) continue;
            String s1 = s.substring(index, index+i);
            if(isValidd(s1)){
                sb.append(s1);
                sb.append('.');
                restoreIpAddress(s,result,index+i, sb,count+1);
                sb.setLength(sb.length()-i-1);
            }

        }

    }

    public boolean isValidd(String s){
        int v = Integer.parseInt(s);
        return (v<=255 &&v>=0) && !(s.charAt(0)=='0' && s.length()>1)?true:false;
    }

}