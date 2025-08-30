class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;

                int d = ch - '1';                 // map '1'..'9' -> 0..8
                int b = (r / 3) * 3 + (c / 3);    // box index 0..8

                if (row[r][d] || col[c][d] || box[b][d]) return false;

                row[r][d] = col[c][d] = box[b][d] = true;
            }
        }
        return true;
    }
}
