class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        //int distinctColors = 0;
        int n = queries.length;
        HashMap<Integer, Integer> ballColor = new HashMap<>();
        //Arrays.fill(ballColor, 0);
        HashMap<Integer, Integer> freq = new HashMap<>();
        int[] res = new int[n];

        for(int i = 0; i < n; i++){
            int ball = queries[i][0];
            int newColor = queries[i][1];
            int existingColor = ballColor.getOrDefault(ball, 0);

            if(newColor != existingColor){
                ballColor.put(ball, newColor);
                int prevColorFreq = freq.getOrDefault(existingColor, 1);
                if(prevColorFreq == 1) freq.remove(existingColor);
                else freq.put(existingColor, prevColorFreq-1);
                freq.put(newColor, freq.getOrDefault(newColor, 0)+1);
            }
            //System.out.println(Arrays.toString(ballColor));

            res[i] = freq.size();
        }

        return res;
        
    }
}