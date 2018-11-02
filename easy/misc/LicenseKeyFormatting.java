class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S=S.toUpperCase();
        StringBuffer sb = new StringBuffer();
        int index=0;
        for(int i=S.length()-1;i>=0;i-=index){
            int count=0;
            index=0;
            for(int j=i;j>=0 && count<K;j--){
                index++;
                if(S.charAt(j)=='-') continue;
                sb.append(S.charAt(j));
                count++;
            }

            sb.append('-');
            //System.out.println(sb);
            //System.out.println(i-index);
        }
        //System.out.println(sb.toString());
        sb=sb.reverse();

        int start=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='-')
                start++;
            else
                break;
        }


        return new String(sb).substring(start,sb.length());
    }
}