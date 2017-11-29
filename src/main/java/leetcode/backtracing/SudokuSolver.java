
/**
 * 数独计算 求解数独。最重要的理解  1）怎么判断有效性。 2）在哪里回溯。
 */
class SudokuSolver {

    public static void main(String[] args) {

    }


    public void solveSudoku(char[][] board) {
        solve(board);
    }


    private boolean solve(char[][] board) {
        for(int i=0; i<board.length;i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j]!='.') {
                    continue;
                }
                for(char k='1'; k<='9'; k++) {
                    if(isValid(board, i, j, k)) {
                        board[i][j]=k;
                        if(solve(board)) {
                            return true;
                        }else {
                            board[i][j]='.';
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {

        for(int j=0; j<9; j++) {
          if(board[row][j]!='.'&&board[row][j]==num) {
            return false;
          }
          if(board[j][col]!='.'&&board[j][col]==num) {
            return false;
          }
          if(board[3*(row/3)+j/3][3*(col/3)+j%3]!='.'&&board[3*(row/3)+j/3][3*(col/3)+j%3]==num) {
            return false;
          }
        }
        return true;
    }
}
