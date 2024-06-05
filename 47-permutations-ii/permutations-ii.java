class Solution {

    List<List<Integer>> res;
    Boolean[] isVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        isVisited = new Boolean[nums.length];
        Arrays.fill(isVisited, false);
        Arrays.sort(nums);

        constructPermutations("", new ArrayList<Integer>(), nums);

        return res;
    }

    void constructPermutations(String currPermutation, List<Integer> currRes, int[] nums){
        if(currRes.size() == nums.length){
            res.add(new ArrayList<>(currRes));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(isVisited[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]) continue;

            isVisited[i] = true;
            currRes.add(nums[i]);
            constructPermutations(currPermutation + String.valueOf(nums[i]) + ",", currRes, nums);
            isVisited[i] = false;
            currRes.remove(currRes.size()-1);
        }
    }
}