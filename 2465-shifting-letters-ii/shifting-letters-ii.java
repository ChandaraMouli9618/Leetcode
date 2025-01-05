class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
 int len = s.length();
        int[] resShifts = new int[len + 1];  // To store the accumulated shifts

        // Apply the shifts to the resShifts array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Direction: 1 for forward, 0 for backward
            int shiftValue = (direction == 1) ? 1 : -1;

            // Update the start and end+1 for the difference array
            resShifts[start] += shiftValue;
            if (end + 1 < len) {
                resShifts[end + 1] -= shiftValue;
            }
        }

        // Accumulate the shifts
        for (int i = 1; i <= len; i++) {
            resShifts[i] += resShifts[i - 1];
        }

        // Apply the accumulated shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            int shift = resShifts[i];

            // Shift the character and handle wrapping
            char shiftedChar = getResChar(ch, shift);
            result.append(shiftedChar);
        }

        return result.toString();
    }

    char getResChar(char ch, int shift){
        shift %= 26;
        return (char)((ch - 'a' + shift + 26 ) % 26 + 'a');
    }
}