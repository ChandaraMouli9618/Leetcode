class Solution {
    public String clearDigits(String s) {
        Stack<Character> charStack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch >= '0' && ch <= '9' && !charStack.isEmpty()) charStack.pop();
            else charStack.push(ch);
        }
        String res = "";
        while(!charStack.isEmpty()){
            res = charStack.pop() + res;
        }

        return res;
    }
}