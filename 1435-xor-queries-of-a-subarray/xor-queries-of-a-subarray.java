class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] preXOR = new int[n+1];

        preXOR[0] = 0;
        for(int i = 1; i <= n; i++){
            preXOR[i] = (preXOR[i-1] ^ arr[i-1]);
        }

        //System.out.println(Arrays.toString(preXOR));

        int queryCount = queries.length;
        int[] res = new int[queryCount];
        for(int i = 0 ; i < queryCount; i++){
            int[] q = queries[i];
            res[i] = preXOR[q[1]+1] ^ preXOR[q[0]];
            //System.out.println(preXOR[q[1]+1] + " " + preXOR[q[0]+1]);
        }


        return res;

    }
}