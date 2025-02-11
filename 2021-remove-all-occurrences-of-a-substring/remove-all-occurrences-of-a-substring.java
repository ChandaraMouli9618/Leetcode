class Solution {
    public String removeOccurrences(String s, String part) {
        if(part.length() > s.length()) return s;
        
        StringBuffer sb = new StringBuffer(s);
        while(sb.length() >= part.length()){
            int startIndex = sb.indexOf(part);
            if(startIndex == -1) break;
            sb.delete(startIndex, startIndex+part.length());
        }

        return sb.toString();
    }
}