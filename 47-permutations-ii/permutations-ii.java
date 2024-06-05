class Solution {

    List<List<Integer>> res;
    Set<String> set;
    Boolean[] isVisited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        set = new HashSet<>();
        isVisited = new Boolean[nums.length];
        Arrays.fill(isVisited, false);

        constructPermutations("", new ArrayList<Integer>(), nums);

        return res;
    }

    void constructPermutations(String currPermutation, List<Integer> currRes, int[] nums){
        if(currRes.size() == nums.length){
            if(!set.contains(currPermutation)){
                set.add(currPermutation);
                res.add(new ArrayList<>(currRes));
                // System.out.println(currPermutation);
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(isVisited[i]) continue;

            isVisited[i] = true;
            currRes.add(nums[i]);
            constructPermutations(currPermutation + String.valueOf(nums[i]) + ",", currRes, nums);
            isVisited[i] = false;
            currRes.remove(currRes.size()-1);
        }
    }
}