class Solution {
    public String addSpaces(String s, int[] spaces) {
        Arrays.sort(spaces);
        StringBuffer sb = new StringBuffer(s);
        for(int i=0; i < spaces.length; i++) sb.insert(i+spaces[i], " ");
        return sb.toString();
    }

}