import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        // Build dictionaries
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String masked = mask(lower);

            // first occurrence only
            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(masked, word);
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exact.contains(q)) {
                result[i] = q; // exact match
            } else {
                String lower = q.toLowerCase();
                String masked = mask(lower);

                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower);
                } else if (vowelInsensitive.containsKey(masked)) {
                    result[i] = vowelInsensitive.get(masked);
                } else {
                    result[i] = "";
                }
            }
        }

        return result;
    }

    private String mask(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*'); // replace vowels with *
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
