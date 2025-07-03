class Solution {
    public char kthCharacter(int k) {
        return helper(k-1);
    }


    char helper(int i){
        if(i == 0) return 'a';
        char res = helper(i/2);

        if(i%2 == 1) {
            if(res == 'z') return 'a';
            return (char)(res + 1);
        }
        return res;
    }
}