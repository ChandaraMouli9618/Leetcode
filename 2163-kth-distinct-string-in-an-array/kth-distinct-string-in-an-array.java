class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> strMap = new HashMap<>();
        for(String str : arr){
            strMap.put(str, strMap.getOrDefault(str, 0)+1);
        }
        
        int count = 0;
        for(String str : arr){
            if(strMap.get(str) == 1) count++;
            if(count == k) return str;
        }
        return "";
    }
}