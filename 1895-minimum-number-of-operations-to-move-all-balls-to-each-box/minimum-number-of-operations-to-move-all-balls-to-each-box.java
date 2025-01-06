class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];

        int ballCount = 0;
        int moves = 0;

        for(int i = 0; i < n; i++){
            moves += ballCount;
            if(boxes.charAt(i) == '1') ballCount++;
            res[i] = moves;
        }
        //System.out.println(Arrays.toString(leftMoves));

        ballCount = 0;
        moves = 0;

        for(int i = n - 1; i >= 0 ; i--){
            moves += ballCount;
            if(boxes.charAt(i) == '1') ballCount++;
            res[i] += moves;
        }

        return res;
    }
}