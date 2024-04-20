class Solution {
    public int[][] findFarmland(int[][] land) {
        int row = land.length;
        int col = land[0].length;
        ArrayList<int[]> farmlandCoordinates = new ArrayList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(land[i][j] == 1){
                    farmlandCoordinates.add(
                        getCoordinates(land, i, j, row, col)
                    );
                }
            }
        }

        int[][] res = new int[farmlandCoordinates.size()][4];
        for(int i = 0; i < farmlandCoordinates.size(); i++){
            res[i] = farmlandCoordinates.get(i);
        }

        return res;
    }

    int[] getCoordinates(int[][] land, int x, int y, int row, int col){
        int[] currCoordinates = new int[4];
        currCoordinates[0] = x;
        currCoordinates[1] = y;

        while( x+1 < row && land[x+1][y] != 0) x++;
        while( y+1 < col && land[x][y+1] != 0) y++;

        currCoordinates[2] = x;
        currCoordinates[3] = y;

        makeFarmlandZero(currCoordinates, land);

        return currCoordinates;
    }

    void makeFarmlandZero(int[] coordinates, int[][] land){
        for(int i = coordinates[0]; i <= coordinates[2]; i++){
            for(int j = coordinates[1]; j <= coordinates[3]; j++){
                land[i][j] = 0;
            }
        }
    } 
}