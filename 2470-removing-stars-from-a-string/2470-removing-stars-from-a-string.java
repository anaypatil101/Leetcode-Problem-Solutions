class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s);

        int i = 0;
        while(i < sb.length()){
            if(sb.charAt(i) == '*') {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                i = i - 1;
            }
            else {
                i++;
            }
        }

        return sb.toString();
    }
}