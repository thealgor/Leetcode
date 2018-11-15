实现bigInt的class，实现加法或者减法或者乘法。
follow up是三个数,以及小数，负数，还有带小数点的数。为了防止有减数过大，应该再写个判断两个字符串代表的数字大小。

// 加法是都从length()-1开始找，分别加。
class BigInt{
	String number;
	public BigInt(String number){
		this.number = number;
	}
	//加法这个方法就是控制好两个指针与末尾的距离相等就可以了。
	public String addBigInt(String toAdd){
		StringBuilder sb = new StringBuilder();
		int i = number.length()-1;
		int j = toAdd.length()-1;
		int carrier = 0;
		while (i >= 0 || j >= 0) {
			int sum = carrier;
			//这里注意要变i和j，每次都往前移，而且这两个是不相等的！
			if (i >= 0) {
				sum += number.charAt(i--) - '0';
			}
			if (j >= 0) {
				sum += toAdd.charAt(j--) - '0';
			}
			sb.append(sum%10);
			carrier = sum/10;
		}
		if (carrier != 0) {
			sb.append(carrier);
		}
		return sb.reverse().toString();
	}
	
	//减法, 必须保证减数小于被减数。
	public String subtractBigInt(String toSub){
        int i = number.length() - 1;
        int j = toSub.length() - 1;
        int carrier = 0;
        StringBuilder sb = new StringBuilder();
        //反正和加法非常的相似。
        while (i >= 0 || j >= 0){
            int sum = -carrier;
            if (i >= 0){
                sum += number.charAt(i--) - '0';
            }
            if (j >= 0){
                sum -= toSub.charAt(j--) - '0';
            }

            if (sum < 0){
                sum += 10;
                carrier = 1;
            }
            sb.append(sum);
        }
        if(sb.charAt(sb.length()-1) == '0'){
            sb.deleteCharAt(sb.length()-1);
        }
        String result = sb.reverse().toString();
        return result.length() == 0 ? "0" : result;		
	}

	//乘法
    public String multiplyInt(String toMulti){
        int toMultiLen = toMulti.length();
        int numLen = number.length();
        int[] result = new int[numLen + toMultiLen];
        //  先number再toMulti
        for (int i = numLen-1; i >= 0; i--){
            for (int j = toMultiLen-1; j >= 0; j--){
    		//  先加上最后一位的东西,从低位开始加。
                int mulPdt = (number.charAt(i) - '0') * (toMulti.charAt(j) - '0') + result[i+j+1];
                result[i+j+1] = mulPdt % 10;
            // += 是为了存上carrier给下一位用,就是进位嘛。
                result[i + j] += mulPdt/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++){
            if (sb.length() == 0 && result[i] == 0) continue;//跳过初始的0
            sb.append(String.valueOf(result[i]));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    //判断大小
    public boolean compareBigInt(String toComp){
        if (number.length() < toComp.length()) return false;
        if (number.length() > toComp.length()) return true;
        for (int i = 0; i < number.length(); i++){
            int numc = number.charAt(i) - '0';
            int toCompc = toComp.charAt(i) - '0';
            if (numc < toCompc){
                return false;
            }
            else if (numc > toCompc){
                return true;
            }
        }
        return true;
    }
}