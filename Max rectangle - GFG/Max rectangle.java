class Solution {
    static int maxArea(int mat[][]) {
         code here
        int n = mat.length;
        int m = mat[0].length;
        int[] height = new int[m];
        for (int j = 0; j  m; j++) {
            height[j] = mat[0][j];
        }
        int maxArea = largestRectangleArea(height);
        for (int i = 1; i  n; i++) {
            for (int j = 0; j  m; j++) {
                if (mat[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(height));
        }
        return maxArea;
    }
    static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        StackInteger stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i = n; i++) {
            int h = (i == n)  0  heights[i];
            while (!stack.isEmpty() && h  heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty()  i  i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height  width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}