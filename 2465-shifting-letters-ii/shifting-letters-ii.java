class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len = s.length();
        int[] resShifts = new int[len + 1];
        Arrays.fill(resShifts, 0);

        for(int[] shift : shifts){
            int direction = shift[2] == 1 ? 1 : -1;

            resShifts[shift[0]] += direction;
            resShifts[shift[1]+1] -= direction;
        }

        System.out.println(Arrays.toString(resShifts));

        StringBuilder res = new StringBuilder("");
        for(int i = 1; i <= len; i++){
            resShifts[i] += resShifts[i-1];
        }

        for(int i = 0; i < len; i++){
            char ch = getResChar(s.charAt(i), resShifts[i]);
            res.append(ch);
        }

        return res.toString();
    }

    char getResChar(char ch, int shift){
        shift %= 26;
        return (char)((ch - 'a' + shift + 26 ) % 26 + 'a');
    }
}