class Solution {
    public char kthCharacter(int k) {
        String src = "a";
        while(src.length() < k){
            src = getNextString(src);
            //System.out.println(src);
        }

        return src.charAt(k-1);
    }

    private String getNextString(String str){
        StringBuilder nextString = new StringBuilder("");
        for(char ch : str.toCharArray()){
            nextString.append((char)(((ch - 'a' + 1) % 26) + 'a'));
        }

        return str + nextString.toString();
    }
}