class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder("");
        for(char ch : s.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            sb.append(ch);
        }

       return sb.toString().equals(sb.reverse().toString());
    }
}