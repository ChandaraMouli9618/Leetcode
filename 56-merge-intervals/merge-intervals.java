class Solution {
    public int[][] merge(int[][] intrs) {
        Arrays.sort(intrs, (a,b)->(a[0]-b[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intrs[0]);
        int n = intrs.length;

        for(int i = 1; i < n; i++){
            int prevRightBoundry = res.get(res.size()-1)[1];
            if(prevRightBoundry >= intrs[i][0]){
                res.get(res.size()-1)[1] = Math.max(prevRightBoundry, intrs[i][1]);
            }
            else res.add(intrs[i]);
        }

        int[][] ans = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);

        return ans;

        
    }
}