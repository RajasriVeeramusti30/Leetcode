class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        for(char ch:s.toCharArray()) {
            if(vowels.indexOf(ch) != -1) {
                vowelList.add(ch);
            }
        }
        Collections.sort(vowelList);
        StringBuilder result = new StringBuilder();
        int vIndex=0;
        for(char ch:s.toCharArray()) {
            if(vowels.indexOf(ch) != -1) {
                result.append(vowelList.get(vIndex++));
            }
            else{
                result.append(ch);

            }
        }
        return result.toString();
    }
}