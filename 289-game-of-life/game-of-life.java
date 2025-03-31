class Solution {
    int[] X = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    int[] Y = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        String nextState = "";
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                int futureState = getFutureState(r, c, board);
                nextState += (char)(futureState + '0');
            }
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                board[r][c] = nextState.charAt(r*cols + c)-'0';
            }
        }
    }

    int getFutureState(int r, int c,int[][] board){
        int liveCellCount = getLiveNeighborCellCount(r, c, board);
        int currentState = board[r][c];
        if(currentState == 1){
            if(liveCellCount < 2) return 0;
            else if(liveCellCount >= 2 && liveCellCount <= 3) return 1;
        }
        else if(liveCellCount == 3) return 1;
        
        return 0;
    }

    int getLiveNeighborCellCount(int r, int c, int[][] board){
        int liveCellCount = 0;
        for(int i = 0; i < X.length; i++){
            int x = r + X[i];
            int y = c + Y[i];
            if(isValidCell(x, y, board)){
                liveCellCount++;
            }
        }

        return liveCellCount;
    }

    boolean isValidCell(int r, int c, int[][] board){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0) return false;
        return true;
    }
}