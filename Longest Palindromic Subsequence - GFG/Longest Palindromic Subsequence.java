//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.longestPalinSubseq(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestPalinSubseq(String s) {
        // code here
        String B = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, s, B, dp);
    }

    private static int f(int i, int j, String s, String B, int[][] dp) {
        if (i >= s.length() || j >= B.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == B.charAt(j)) {
            dp[i][j] = 1 + f(i + 1, j + 1, s, B, dp);
        } else {
            dp[i][j] = Math.max(f(i + 1, j, s, B, dp), f(i, j + 1, s, B, dp));
        }
        return dp[i][j];
    }
}