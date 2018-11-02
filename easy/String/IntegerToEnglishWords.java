class Solution {

    String[] belowTwenty = " One Two Three Four Five Six Seven Eight Nine Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split(" ");
    //String[] belowTwenty = "Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen".split(" ");
    String[] tens = " Ten Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety".split(" ");
    final int BILLION = 1000000000, MILLION=1000000, THOUSAND=1000, HUN=100;

    public String numberToWords(int num) {
        if(num==0) return "Zero";
        return helper(num);
    }

    public String helper(int num){
        String result = new String();
        if(num<20) result = belowTwenty[num];
        else if(num<HUN) result  = tens[num/10]+" "+helper(num%10);
        else if(num<THOUSAND) result = helper(num/HUN)+" Hundred "+helper(num%HUN);
        else if(num<MILLION) result = helper(num/THOUSAND)+" Thousand "+helper(num%THOUSAND);
        else if(num<BILLION) result = helper(num/MILLION)+" Million "+helper(num%MILLION);
        else result = helper(num/BILLION)+" Billion "+ helper(num%BILLION);
        return result.trim();

    }


}