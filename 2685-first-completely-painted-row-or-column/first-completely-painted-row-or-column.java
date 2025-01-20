class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, Integer> X = new HashMap<>();
        Map<Integer, Integer> Y = new HashMap<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                X.put(mat[i][j], i);
                Y.put(mat[i][j], j);
            }
        }

        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i = 0; i < arr.length; i++){
            int x = X.get(arr[i]);
            int y = Y.get(arr[i]);

            // rows[x]++;
            // cols[y]++;

            // System.out.println (Arrays.toString(rows));
            // System.out.println (Arrays.toString(cols));
            // System.out.println ();
            if(++rows[x] == n) return i;
            if(++cols[y] == m) return i;
        }

        return -1;
    }
}