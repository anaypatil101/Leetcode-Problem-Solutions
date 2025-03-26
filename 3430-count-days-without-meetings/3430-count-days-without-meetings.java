class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> (a[0] - b[0]));
        int start = -1, end = 0, result = 0;
        
        for(int i=0; i<meetings.length; i++) {
            start = meetings[i][0];
            if(start > end) {
                result += start - end - 1;
            }
            end = Math.max(end, meetings[i][1]);
        }

        if(end < days) {
            result += days - end;
        }
        return result;
    }
}