给你几个数字，判断他们做加减乘除运算是否可以得到24，顺序可以是任意的。
因为只需要看能不能，所以DFS就行。

class Solution{

	//竟然一开始忘了返回类型。
	public boolean get24(double[] input){
		int len = input.length;
		return dfs(input, len);
	}
	public boolean dfs(double[] input, int remainNum){
		if (remainNum == 1) {
			if (input[0] == 24) {
				return true;
			}
		}
		if (remainNum <= 1) {
			return false;
		}
		for (int i = 0; i < remainNum; i++) {
			for (int j = i + 1; j < remainNum; j++) {
				double first = input[i];
				double second = input[j];
				input[j] = input[remainNum-1];
				input[i] = first + second;
				if (dfs(input, remainNum-1)) {
					return true;
				}
				input[i] = first - second;
				if (dfs(input, remainNum-1)) {
					return true;
				}
				input[i] = second - first;
				if (dfs(input, remainNum-1)) {
					return true;
				}
				input[i] = first * second;
				if (dfs(input, remainNum-1)) {
					return true;
				}
				if (second != 0) {
					input[i] = first/second;
					if (dfs(input, remainNum-1)) {
						return true;
					}					
				}				
				if (first != 0) {
					input[i] = second/first;
					if (dfs(input, remainNum-1)) {
						return true;
					}
				}
				//只需要在这里backtrack就可以，因为之前就算恢复了，也要再取回来。
				input[i] = first;
				input[j] = second;
			}
		}
		return false;
	}
}