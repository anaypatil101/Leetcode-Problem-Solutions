class Solution {
    public int characterReplacement(String s, int k) {
         int[] hash = new int[26];
        int n = s.length(), maxf = 0;

        int l = 0, r = 0, ans = 0;
        for(r=0; r<n; r++) {
            hash[s.charAt(r) - 'A']++;

            maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);

             while((r - l + 1) - maxf > k) {
                    hash[s.charAt(l) - 'A']--;
                    maxf = 0;
                    for(int i=0; i<26; i++) {
                        maxf = Math.max(maxf, hash[i]);
                    }
                    l++;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}