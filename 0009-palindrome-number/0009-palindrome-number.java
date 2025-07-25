class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reversed = 0;
        int num = x;

        while (num > 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num = num / 10;
        }

        return x == reversed;
    }
}
