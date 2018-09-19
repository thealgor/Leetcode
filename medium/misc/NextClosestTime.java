package medium.misc;

class NextClosestTime {
    public String nextClosestTime(String time) {

        Set<String> set = new HashSet<String>();
        set.add(time);
        char[] cs = new char[4];
        int k=0;
        for(int i=0;i<time.length();i++){
            char c = time.charAt(i);
            if(c==':') continue;
            cs[k++]=c;
        }
        Arrays.sort(cs);
        Queue<String> q = new LinkedList<String>();
        q.add(time);
        String minValue = "";

        while(!q.isEmpty()){
            String t = q.poll();
            set.add(t);
            for(int i=0;i<t.length();i++){
                for(int j=0;j<cs.length;j++){
                    if(i==2) continue;
                    String str = t.substring(0,i)+Character.toString(cs[j])+t.substring(i+1,t.length());
                    if(validTime(str) && !set.contains(str)){
                        q.add(str);
                        //System.out.println(str);
                        int result = str.compareTo(time);
                        if(result>0){
                            if(minValue.equals("")){
                                minValue = str;
                                continue;
                            }
                            else{
                                int r = str.compareTo(minValue);
                                if(r<0)
                                    minValue = str;
                            }

                        }
                    }


                }
            }

        }
        if(minValue.equals("")){
            return cs[0]+""+cs[0]+":"+cs[0]+""+cs[0];
        }
        return minValue;
    }



    public boolean validTime(String time){
        int h = Integer.parseInt(time.substring(0,2));
        int m = Integer.parseInt(time.substring(3,5));
        if(h>=0 && h<=23 && m>=0 && m<=59)
            return true;
        return false;
    }


}
