package medium.Backtracking;


//O(3^N) time O(N) recursion space.
class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length() == 0)
            return result;
        StringBuilder sb = new StringBuilder();
        String[] phone = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        backtrack(result,sb,digits,0,phone);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder sb, String digits, int index,String[] phone){
        if(sb.length()==digits.length()){
            result.add(new String(sb));
        }

        for(int i=index;i<digits.length();i++){
            String phonePos = phone[Character.getNumericValue(digits.charAt(i))] ;
            char[] cp = phonePos.toCharArray();
            for(char c: cp){
                sb = sb.append(c);
                backtrack(result,sb,digits,i+1,phone);
                sb.setLength(sb.length() - 1);
            }

        }
    }

    public List<String> letterCombinationsBFS(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
    }

}