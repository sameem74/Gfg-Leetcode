class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = n - 1; i >= 0; i--) {
            int[] temp = freq.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                if (temp[idx] == 0) {
                    possible = false;
                    break;
                }
                temp[idx]--;
            }
            if (!possible) {
                continue;
            }
            int targetChar = target.charAt(i) - 'a';
            for (int c = targetChar + 1; c < 26; c++) {
                if (temp[c] > 0) {
                    StringBuilder ans = new StringBuilder();
                    for (int j = 0; j < i; j++) {
                        ans.append(target.charAt(j));
                    }
                    ans.append((char) ('a' + c));
                    temp[c]--;
                    for (int x = 0; x < 26; x++) {
                        while (temp[x] > 0) {
                            ans.append((char) ('a' + x));
                            temp[x]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
}