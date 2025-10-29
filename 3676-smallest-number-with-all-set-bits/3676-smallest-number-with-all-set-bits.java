class Solution {
    public int smallestNumber(int n) {
        int bitLen = (int) (Math.log(n) / Math.log(2) + 1);
        int setNum = (1 << bitLen) - 1;
        return setNum;
    }
}