class Solution {
    public int possibleStringCount(String word) {
        char[] charArray = word.toCharArray();
        int c=1;
        
        // for(int i=1;i<word.length();i++){
        //     if(word.charAt(i)==word.charAt(i-1)) c++;
        // }
        for(int i=1;i<word.length();i++){
            if(charArray[i]==charArray[i-1]){
                c++;
            }
        }
        
        return c;
    }
}