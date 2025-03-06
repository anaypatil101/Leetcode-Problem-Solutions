class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int max = (n*n);

        int[] hash = new int[max + 1];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int val = grid[i][j];
                hash[val]++;
            }
        }

        // find a (number which appears twice)
        int a = -1;
        for(int i=1; i<hash.length; i++) {
            if(hash[i] == 2) {
                a = i;
                break;
            }
        }

        // find b (number which is missing)
        int b = -1;
        for(int i=1; i<hash.length; i++) {
            if(hash[i] == 0) {
                b = i;
                break;
            }
        }

        return new int[]{a,b};
    }
}