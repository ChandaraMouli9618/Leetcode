class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(String s : s1.split(" ")){
            map1.put(s, map1.getOrDefault(s, 0)+1);
        }

        for(String s : s2.split(" ")){
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        String res = "";
        for(Map.Entry<String, Integer> e : map1.entrySet()){
            if(e.getValue() == 1 && !map2.containsKey(e.getKey())){
                res = res + " " + e.getKey();
            }
        }

        for(Map.Entry<String, Integer> e : map2.entrySet()){
            if(e.getValue() == 1 && !map1.containsKey(e.getKey())){
                res = res + " " + e.getKey();
            }
        }
        if(res.length() == 0) return new String[0];

        return res.trim().split(" ");
    }
}