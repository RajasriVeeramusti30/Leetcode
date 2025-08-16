class Solution {
    public int maximum69Number(int num) {
        // Replace only the first '6' with '9'
        String s = String.valueOf(num).replaceFirst("6", "9");
        return Integer.parseInt(s);
    }
}
