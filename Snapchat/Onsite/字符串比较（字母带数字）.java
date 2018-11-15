问了一个字符串比较问题，说很多用户名都会重复，通过后面的数字来区分，
但是在排序的时候严格按照字符串排序就会出现 abc10 排在 abc2 前面（因为‘1’比‘2’要小），
但是事实上他们想要达到的效果是 abc10 排在 abc2 后面（10比2要大），于是让写一个字符串比较函数。
最后加入到comparator里面去，所以需要返回-1，如果小的话。

------
感觉是切两刀比较，先查字母，再查数字，注意数字有可能会越界。

public class Solution{
	// a > b返回true。
	public boolean compareStr(String a, String b){
		int aIn = 0;
		int bIn = 0;
		while (aIn < a.length()) {
			// 这里注意一下charAt，一开始直接把数字塞进去了。
			if (Character.isDigit(a.charAt(aIn))) {
				break;
			}
			aIn++;
		}
		while (bIn < a.length()) {
			if (Character.isDigit(a.charAt(bIn))) {
				break;
			}
			bIn++;
		}
		for (int i = 0; i < bIn && i < aIn; i++) {
			if (a.charAt(i) < b.charAt(i)) {
				return false;
			}
			else if(a.charAt(i) > b.charAt(i)){
				return true;
			}
		}
		if (aIn != bIn) {
			return aIn > bIn ? true : false;
		}
		String aRemain = a.substring(aIn);
		String bRemain = b.substring(bIn);
		if (aRemain.length() != bRemain.length()) {
			return aRemain.length() > bRemain.length() ? true : false;
		}
		for (int i = 0; i < aRemain.length(); i++) {
			int aCur = aRemain.charAt(i) - '0';
			int bCur = bRemain.charAt(i) - '0';
			if (aCur != bCur) {
				return aCur > bCur;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		
	}
}