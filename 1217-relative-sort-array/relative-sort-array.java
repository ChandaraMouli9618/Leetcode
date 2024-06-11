class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr2.length;
        int m = arr1.length;

        for(int i = n-1; i >= 0; i--){
            map.put(arr2[i], -1*(n-(i+1)));
        }

        List<Node> list = new ArrayList<>();
        for(int i : arr1) list.add(new Node(i, map.getOrDefault(i, i)));
        Collections.sort(list);

        int[] res = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++){
            res[i] = list.get(i).value;
        }

        return res;        
    }
}

class Node implements Comparable<Node>{
    Integer value;
    Integer relValue;

    Node(Integer value, Integer relValue){
        this.value = value;
        this.relValue = relValue;
    }

    public int compareTo(Node node){
        return relValue.compareTo(node.relValue);
    }
}

