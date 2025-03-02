class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;

        while( i < m && j < n){
            List<Integer> currList = new ArrayList<>();
            if(nums1[i][0] == nums2[j][0]){
                currList.add(nums1[i][0]);
                currList.add(nums1[i][1] + nums2[j][1]);
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0]){
                currList.add(nums1[i][0]);
                currList.add(nums1[i][1]);
                i++;
            }
            else{
                currList.add(nums2[j][0]);
                currList.add(nums2[j][1]);
                j++;
            }
            res.add(currList);
        }

        while(i < m) res.add(Arrays.asList(new Integer[]{nums1[i][0],nums1[i++][1]}));
        while(j < n) res.add(Arrays.asList(new Integer[]{nums2[j][0],nums2[j++][1]}));

        int[][] ans = new int[res.size()][2];
        for(int k = 0; k < res.size(); k++){
            ans[k][0] = res.get(k).get(0);
            ans[k][1] = res.get(k).get(1);
        }

        return ans;
    }
}