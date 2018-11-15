用刀砍左上角，每次输出一条斜线的数字。
每次从上面和右边往左下就可以了，i+j的和是相等的。

class Solution{
	public List<List<Integer>> print2D(int[][] arrays){
		List<List<Integer>> result = new ArrayList<>();
		if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
			return result;
		}
		int colNum = arrays[0].length;
		int rowNum = arrays.length;
		int total = rowNum + colNum - 1;
		for (int col = 0; col < ; ) {
			
		}
	}
}
