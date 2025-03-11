class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        for (int i = 0; i < s.length(); ++i) {
            lastSeen[s.charAt(i) - 'a'] = i;
            ans += 1 + Arrays.stream(lastSeen).min().getAsInt();
        }  
        return ans;
    }
}