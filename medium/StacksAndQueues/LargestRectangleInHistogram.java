class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        stack.add(-1);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[stack.peek()]>heights[i])
                maxArea=Math.max(maxArea, heights[stack.pop()]*(i-stack.peek()-1));
            stack.add(i);
        }

        //if its a completely increasing sequeuence in the end
        int i=0;
        while(stack.peek()!=-1){
            maxArea=Math.max(maxArea, heights[stack.pop()]*(heights.length-stack.peek()-1));
        }

        return maxArea;

    }

    public int calculateArea(int[] heights, int start, int end) {
        if (start > end)
            return 0;
        int minindex = start;
        for (int i = start; i <= end; i++)
            if (heights[minindex] > heights[i])
                minindex = i;
        return Math.max(heights[minindex] * (end - start + 1), Math.max(calculateArea(heights, start, minindex - 1), calculateArea(heights, minindex + 1, end)));
    }
    public int largestRectangleAreaDivideAndConquer(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}