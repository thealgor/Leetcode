package easy.StackAndQueues;


class ValidParantheses {
    public boolean isValid(String s) {

        if(s.length()==0)
            return true;

        Map<Character, Character> map = new HashMap<Character,Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        Stack<Character> stack = new Stack<Character>();
        char[] cs = s.toCharArray();

        for(char c: cs){
            if(c=='{'||c=='['||c=='(')
                stack.add(c);
            else if(c=='}'||c==']'||c==')'){
                if(!stack.isEmpty()&&stack.peek()==map.get(c))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();




    }

    public boolean isValidBetterSolution(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}