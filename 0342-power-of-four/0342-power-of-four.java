class Solution {
    public boolean isPowerOfFour(int n) {
        // must be positive
        if (n <= 0) return false;
        
        // check if it's a power of two: only one bit set
        // and check if that bit is at an even position
        return (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}
