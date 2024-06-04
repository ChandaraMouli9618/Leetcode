class Solution {

    int[][] distances;
    int[] X = {0, 1, 0, -1};
    int[] Y = {1, 0, -1, 0};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        distances = new int[m][n];
        for(int[] arr : distances) Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Integer[]> queue = new LinkedList<>();;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.add(new Integer[]{i, j});
                    distances[i][j] = 0;
                }
            }
        }

        int steps = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            System.out.println(size);
            for(int i = 0; i < size; i++){
                Integer[] coords = queue.poll();
                for(int j = 0; j < 4; j++){
                    
                    int x = X[j] + coords[0];
                    int y = Y[j] + coords[1];
                    
                    if( isValid(x, y, m, n, steps, distances) ){
                        distances[x][y] = steps;
                        queue.add(new Integer[]{x, y});
                    }
                }
            }
            
            steps++;
        }

        return distances;
    }

    boolean isValid(int x, int y, int m, int n, int steps, int[][] distances){
        if(x < 0 || y < 0 || x >= m || y >= n || distances[x][y] != Integer.MAX_VALUE) return false;
        return true;
    }
    
}