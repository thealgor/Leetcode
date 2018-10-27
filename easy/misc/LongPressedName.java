class Solution {
    public boolean isLongPressedName(String name, String typed) {

        if(name==null || name.length()<1 || typed.length()<1)
            return true;

        if(name.charAt(0)!=typed.charAt(0)) return false;

        int i=1, j=1;
        while(i<name.length() && j<typed.length()){
            System.out.println(i+","+j);
            if(name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            }

            else if(name.charAt(i)!=typed.charAt(j)){
                if(name.charAt(i-1)!=typed.charAt(j)) return false;
                while(j<typed.length() && name.charAt(i-1)==typed.charAt(j))
                    j++;

                continue;
            }



        }

        while(j<typed.length()){
            if(name.charAt(i-1)==typed.charAt(j))
                j++;
            else
                return false;
        }

        if(i<name.length()) return false;

        return true;
    }
}