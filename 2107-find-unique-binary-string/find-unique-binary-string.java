class Solution {
    Set<String> existingNums;
    public String findDifferentBinaryString(String[] nums) {
        existingNums = new HashSet<>(Arrays.asList(nums));
        return getNewNum(nums[0].length(), new StringBuilder());
    }

    String getNewNum(int n, StringBuilder currStr){
        if(currStr.length() == n){
            if(existingNums.contains(currStr.toString())) return "";
            return currStr.toString();
        }

        for(char ch = '0'; ch <= '1'; ch++){
            currStr.append(ch);
            String currRes = getNewNum(n, currStr);
            if(currRes.length() != 0) return currRes;
            currStr.deleteCharAt(currStr.length()-1);
        }

        return "";
    }
}