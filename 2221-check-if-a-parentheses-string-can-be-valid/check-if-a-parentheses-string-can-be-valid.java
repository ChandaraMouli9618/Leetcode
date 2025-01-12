class Solution {
    public boolean canBeValid(String s, String locked) {
int n = s.length();
        if (n % 2 == 1) return false; // Odd length cannot be a valid parentheses string
        
        int openMin = 0, openMax = 0; // Track min/max possible '(' count

        // Left-to-right pass
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);
            
            if (lock == '1') { // Locked, cannot be changed
                if (ch == '(') {
                    openMin++;
                    openMax++;
                } else {
                    openMin--;
                    openMax--;
                }
            } else { // Unlocked, can be changed
                openMin--;  // Worst case: all '?' become ')'
                openMax++;  // Worst case: all '?' become '('
            }
            
            if (openMax < 0) return false; // Too many ')'
            openMin = Math.max(openMin, 0);
        }

        int closeMin = 0, closeMax = 0; // Track min/max possible ')' count

        // Right-to-left pass
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            char lock = locked.charAt(i);
            
            if (lock == '1') { // Locked, cannot be changed
                if (ch == ')') {
                    closeMin++;
                    closeMax++;
                } else {
                    closeMin--;
                    closeMax--;
                }
            } else { // Unlocked, can be changed
                closeMin--;  // Worst case: all '?' become '('
                closeMax++;  // Worst case: all '?' become ')'
            }
            
            if (closeMax < 0) return false; // Too many '('
            closeMin = Math.max(closeMin, 0);
        }

        return true;

    }
}