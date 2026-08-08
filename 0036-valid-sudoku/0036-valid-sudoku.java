class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] nums = new int[10];

        // for checking all rows
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.')
                    continue;

                int ch = (int) (board[i][j] - '0');
                if(nums[ch] != 0)
                    return false;
                
                nums[ch]++;
            }
            nums = new int[10];
        }

        // for checking all columns
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.')
                    continue;

                int ch = board[j][i] - '0';
                if(nums[ch] != 0)
                    return false;
                
                nums[ch]++;
            }
            nums = new int[10];
        }

        for (int square = 0; square < 9; square++) {
            nums = new int[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    
                    if(board[row][col] == '.')
                    continue;

                    int ch = board[row][col] - '0';
                    if(nums[ch] != 0)
                        return false;
                    
                    nums[ch]++;
                }
            }
        }

        return true;
    }
}