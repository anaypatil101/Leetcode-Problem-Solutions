class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>(); //to get the frequency

        int l = 0, r = 0, maxLen = 0;
        while(r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r],0) + 1);
            if(map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);

                if(map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }
            else {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }   
}