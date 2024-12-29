class Solution {
    private static final long MOD = (long) 1e9 + 7;
    public int numWays(String[] words, String target) {
        final int T = target.length();
        final int C = words[0].length();
        long[] dp = new long[T + 1];
        dp[T] = 1;
        for (int c=C-1;c!=-1;c--)
        {
            long[] prev = dp;
            dp = new long[T + 1];
            dp[T] = 1;
            int[] alphas = new int[26];
            for(String w : words)
            alphas[w.charAt(c) - 'a']++;
            for(int t=T-1;t!=-1;t--)
            {
                int cht = target.charAt(t) - 'a';
                dp[t] = (alphas[cht] * prev[t+1]+ prev[t]) % MOD;
            }
        }
        return (int) dp[0];
    }
}