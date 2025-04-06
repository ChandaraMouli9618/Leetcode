class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        combinationUtil(0, target, candidates, new ArrayList<>());
        return res;
    }

    void combinationUtil(int pos, int sum, int[] candidates, List<Integer> currRes){
        if(sum == 0){
            res.add(new ArrayList(currRes));
            return;
        }
        if(pos == candidates.length) return;

        if(candidates[pos] <= sum){
            currRes.add(candidates[pos]);
            combinationUtil(pos, sum - candidates[pos], candidates, currRes);
            currRes.remove(currRes.size()-1);
        }
        combinationUtil(pos+1, sum, candidates, currRes);
    }
}