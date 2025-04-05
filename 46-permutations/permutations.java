class Solution {
    List<List<Integer>> res;
    boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        isVisited = new boolean[n];
        res = new ArrayList<>();
        permutationUtil(0, nums, new Integer[n]);
        return res;
    }

    void permutationUtil(int pos, int[] nums, Integer[] currRes){
        if(pos == nums.length){
            res.add(new ArrayList<Integer>(Arrays.asList(currRes)));
            return;
        }

        for(int i = 0 ; i < nums.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                currRes[pos] = nums[i];
                permutationUtil(pos+1, nums, currRes);
                isVisited[i] = false;
            }
        }
    }
}