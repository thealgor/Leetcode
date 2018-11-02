class Solution {
    public String countAndSay(int n) {
        //use stringbuilder whenever you can
        StringBuilder sb = new StringBuilder("");
        if(n==0)
            return "";
        if(n==1)
            return "1";

        String prev = "1";
        for(int i=2;i<=n;i++){
            sb.setLength(0);
            int j=0;
            while(j<prev.length()){
                int count=1;
                while((j+1)<prev.length() && (prev.charAt(j)==prev.charAt(j+1))){
                    count++;
                    j++;
                }

                if(count>1)
                    sb.append(count+""+prev.charAt(j));
                else
                    sb.append("1"+""+prev.charAt(j));

                j++;
            }

            prev=new String(sb);
        }
        return new String(sb);
    }
}