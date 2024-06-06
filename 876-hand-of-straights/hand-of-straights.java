import java.util.SortedMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n  = hand.length;
        if(n % groupSize != 0) return false;

        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        for(int i : hand) sortedMap.put(i, sortedMap.getOrDefault(i, 0)+1);

        while(!sortedMap.isEmpty()){
            if(sortedMap.size() < groupSize) return false;
            Integer[][] currGroup = getBeginingElements(sortedMap, groupSize);

            int minFreq = currGroup[0][1];

            for(int i = 1; i < currGroup.length; i++){
                if(currGroup[i][1] < currGroup[i-1][1]) return false;
                if(currGroup[i][0]-1 != currGroup[i-1][0]) return false;
            }

            for(int i = 0; i < currGroup.length; i++){
                int currKey = currGroup[i][0];
                if(sortedMap.get(currKey) == minFreq) sortedMap.remove(currKey);
                else sortedMap.put(currKey, sortedMap.get(currKey) - minFreq);
            }
        }

        return true;
    }

    Integer[][] getBeginingElements(Map<Integer, Integer> map, int size){
        int count = 0;
        Integer[][] pairs = new Integer[size][2];
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        while(count < size){
            Map.Entry<Integer, Integer> curr = iterator.next(); 
            pairs[count][0] = curr.getKey();
            pairs[count][1] = curr.getValue();
            count++;
        }

        return pairs;
    }
}