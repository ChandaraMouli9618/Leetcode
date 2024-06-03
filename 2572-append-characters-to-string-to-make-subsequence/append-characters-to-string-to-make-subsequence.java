class Solution {
    public int appendCharacters(String s, String t) {
        int a = 0, b = 0;
        int m = s.length(), n = t.length();

        while(a < m && b < n){
            if(s.charAt(a) == t.charAt(b)) b++;
            a++;
        }
        return n-b;
    }
}