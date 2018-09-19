package medium.Graphs;

class RemoveInvalidParantheses {
    public List<String> removeInvalidParentheses(String s) {

        Queue<String> q = new LinkedList<String>();
        List<String> result = new ArrayList<String>();
        Set<String> visited = new HashSet<String>();
        boolean foundSolution=false;
        q.add(s);
        q.add(null);

        if(isValid(s)){

            result.add(s);
            return result;
        }

        while(!q.isEmpty()){
            String str = q.poll();

            if(str==null){
                if(foundSolution)
                    break;
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }

            for(int i=0;i<=str.length()-1;i++){
                if(str.charAt(i)=='('|| str.charAt(i)==')'){
                    String s1 = str.substring(0, i) + str.substring(i+1);
                    //System.out.println(s1);
                    if(visited.contains(s1))
                        continue;
                    visited.add(s1);
                    q.add(s1);
                    if(isValid(s1)){
                        result.add(s1);
                        foundSolution=true;
                    }
                }
            }
        }

        if(result.size()==0){

            String res = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='('||s.charAt(i)==')')
                    continue;
                else
                    res+=Character.toString(s.charAt(i));
            }
            result.add(res);
        }


        return result;


    }


    public boolean isValid(String s){
        int left=0, right=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                left++;
            else if(s.charAt(i)==')')
                right++;

            if(right>left)
                return false;
        }

        if(left==right)
            return true;

        return false;
    }




}