class Solution {
    public String clearDigits(String s) {
        Stack<Character> charStack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9' && !charStack.isEmpty()) charStack.pop();
            else charStack.push(ch);
        }
        StringBuffer res = new StringBuffer();
        while(!charStack.isEmpty()){
            res.append(charStack.pop());
        }

        return res.reverse().toString();
    }
}