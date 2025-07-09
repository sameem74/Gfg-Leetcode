class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }
        int mod = (int)1e9 + 7;
        int total = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * prevLess[i] * nextLess[i];
            total += contrib;
        }
        return total;
    }
}
