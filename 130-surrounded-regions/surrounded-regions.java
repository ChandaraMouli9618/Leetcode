class Solution {
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};
    public void solve(char[][] board) {
        Queue<Integer[]> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < n; i++) if(board[0][i] == 'O') queue.add(new Integer[]{0, i});
        for(int i = 0; i < n; i++) if(board[m-1][i] == 'O') queue.add(new Integer[]{m-1, i});
        for(int i = 1; i < m-1; i++) if(board[i][0] == 'O') queue.add(new Integer[]{i, 0});
        for(int i = 1; i < m-1; i++) if(board[i][n-1] == 'O') queue.add(new Integer[]{i, n-1});

        while(!queue.isEmpty()){
            Integer[] coords = queue.poll();
            dfs(coords[0], coords[1], m, n, board); 
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'K') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void dfs(int x, int y, int m, int n, char[][] board){
        if(x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;

        board[x][y] = 'K';
        for(int i = 0; i < 4; i++){
            dfs(x+X[i], y+Y[i], m, n, board);
        }
    }
}