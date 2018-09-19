package medium.Backtracking;

class GenerateParantheses {
    public List<String> generateParenthesisbfs(int n) {
        List<String> result = new ArrayList<String>();

        if(n==0)
            return result;
        Queue<String> q = new LinkedList<String>();
        String ls= "(", rs=")";
        int lc=0, rc=0;
        q.add(ls);
        q.add(null);
        int count = 1;
        lc++;
        n=2*n;

        while(!q.isEmpty() && count<=n){
            String curr = q.poll();
            //System.out.println(curr);

            if(curr==null){

                if(count==n)
                    break;

                if(!q.isEmpty())
                    q.add(null);
                count++;
                continue;
            }

            if(count==n){
                if(isValid(curr, n))
                    result.add(curr);
                continue;
            }

            q.add(curr+ls);
            q.add(curr+rs);

        }

        return result;
    }



    public boolean isValid(String curr, int n){
        int left = n/2, right=n/2;

        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)=='(')
                left--;
            if(curr.charAt(i)==')')
                right--;
            if(right < left)
                return false;
        }

        if(left!=0 || right!=0)
            return false;

        return true;
    }


    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }



}