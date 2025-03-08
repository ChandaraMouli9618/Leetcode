class Solution {
    public int minimumRecolors(String blocks, int k) {
        int white = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k-1; i++){
            if(blocks.charAt(i) =='W') white++;
        }

        for(int i = k-1; i < blocks.length(); i++){
            if(blocks.charAt(i) =='W') white++;
            res = Math.min(white, res);
            if(blocks.charAt(i-k+1) =='W') white--;
        }

        return res;
    }
}