class Solution {
    public int longestPalindrome(String[] words) {
        int[][] freq = new int[26][26];
        int count = 0;
        for(String word : words){
            int i = word.charAt(0)-'a';
            int j = word.charAt(1)-'a';
            if(freq[j][i] > 0){
                freq[j][i]--;
                count+=2;
            }else{
                freq[i][j]++;
            }
        }
        for(int i=0;i<26;i++){
            if(freq[i][i] != 0){
                count++;
                break;
            }
        }
        return count*2;
    }
}