class Solution {
    public int minAddToMakeValid(String s) {
        int currLeftBrac = 0;
        int reqLeftBrac = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(currLeftBrac == 0) reqLeftBrac++;
                else currLeftBrac--;
            }
            else{
                currLeftBrac++;
            }
        }

        return currLeftBrac + reqLeftBrac;
    }
}