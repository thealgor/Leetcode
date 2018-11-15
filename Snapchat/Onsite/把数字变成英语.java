比如821输出eight hundred twenty-one。
1. 如果输入是trillion级别或者0.000...3这种需要怎么做 
2. 代码有哪些地方可以改进增加可读性

class Solution {
public:
    string numberToWords(int num) {
        if(num==0)  return "Zero";
        string res = helper(num);
        return res.substr(1);
    }
private:
	//照着这个思路就行。
    string digits[20] = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    string tens[10] = {"Zero", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    string helper(int n){
        if(n>=1000000000)
            return helper(n/1000000000) + " Billion" + helper(n%1000000000);
        if(n>=1000000)
            return helper(n/1000000) + " Million" + helper(n%1000000);
        if(n>=1000)
            return helper(n/1000) + " Thousand" + helper(n%1000);
        if(n>=100)
            return helper(n/100) + " Hundred" + helper(n%100);
        if(n>=20)
            return " " + tens[n/10] + helper(n%10);
        if(n>=1)
            return " " + digits[n];
        return "";
    }
};