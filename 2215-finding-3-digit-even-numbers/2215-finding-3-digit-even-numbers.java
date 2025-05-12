import java.util.*;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] freq = new int[10];

        // Count frequency of each digit
        for (int d : digits) {
            freq[d]++;
        }

        // Try all 3-digit combinations (100 to 999)
        for (int i = 100; i < 1000; i++) {
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            if (c % 2 != 0) continue; // Must be even

            int[] count = new int[10];
            count[a]++;
            count[b]++;
            count[c]++;

            boolean valid = true;
            for (int d = 0; d < 10; d++) {
                if (count[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(i);
        }

        // Convert Set<Integer> to int[]
        int[] output = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            output[idx++] = num;
        }

        return output;
    }
}
