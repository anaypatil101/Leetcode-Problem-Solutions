class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int left = 0, i = 0, count = 0;
        StringBuilder result = new StringBuilder();

        while(i < n && count != k) {
            if(s.charAt(i) == ' ') {
                result.append(s.substring(left, i));
                left = i;
                count++;
            }

            if(i == n - 1) {
                result.append(s.substring(left,i+1));
            }

            i++;
        }

        return result.toString();
    }
}