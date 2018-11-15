public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            //如果只有1到9的话这段改成把number赋值，而不是×10了。
            if(Character.isDigit(cur)){
                number = number * 10 + (int)(cur-'0');
            }
            //这里有个滞后性，就是判断如果遇到了运算符，那么就把之前的sign处理掉换成这个新的。
            if((!Character.isDigit(cur) && cur != ' ')){
                if(sign == '+'){
                    stack.push(number);
                }
                if(sign == '-'){
                    stack.push(-number);
                }
                if(sign == '*'){
                    stack.push(stack.pop()*number);
                }
                if(sign == '/'){
                    stack.push(stack.pop()/number);
                }
                sign = cur;
                number = 0;
            }
        }
        int result = 0;
        for(int i : stack){
            result += i;
        }
        return result;
    }
}