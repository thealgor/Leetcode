class Solution {
    public int numUniqueEmails(String[] emails) {
        if(emails==null || emails.length<1)
            return 0;

        int count = 0;
        Set<String> set = new HashSet();
        for(String e: emails){
            String[] ps = e.split("@");
            String name = "";
            name = ps[0].split("\\+")[0];
            name=name.replace(".","");
            String email = name+'@'+ps[1];
            if(!set.contains(email)){
                set.add(email);
                count++;
            }
        }
        return count;

    }
}