class NumberContainers {

    Map<Integer, Integer> indexMap;
    Map<Integer, TreeSet<Integer>> numberMap;
    public NumberContainers() {
        indexMap = new HashMap<>();
        numberMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        int prevNum = indexMap.getOrDefault(index, 0);
        if(prevNum > 0){
            numberMap.get(prevNum).remove(index);
            if(numberMap.get(prevNum).size() == 0) numberMap.remove(prevNum);
        }
        indexMap.put(index, number);

        if(!numberMap.containsKey(number)){
            numberMap.put(number, new TreeSet<Integer>());
        }
        numberMap.get(number).add(index);
    }
    
    public int find(int number) {
        if(!numberMap.containsKey(number)) return -1;
        return numberMap.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */