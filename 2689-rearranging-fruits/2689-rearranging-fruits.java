class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = basket1.length;
        int minElement = Integer.MAX_VALUE;
        // Count frequency difference and track the minimum element
        for (int i = 0; i < n; i++) {
            freq.put(basket1[i], freq.getOrDefault(basket1[i], 0) + 1);
            freq.put(basket2[i], freq.getOrDefault(basket2[i], 0) - 1);
            minElement = Math.min(minElement, Math.min(basket1[i], basket2[i]));
        }
        // List to hold items that need to be swapped
        List<Integer> swapList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey();
            int diff = entry.getValue();

            // If difference is odd, return -1
            if (diff % 2 != 0) return -1;

            // Add half the absolute diff to swap list
            for (int i = 0; i < Math.abs(diff) / 2; i++) {
                swapList.add(fruit);
            }
        }
        // Sort the swap list to always choose cheapest swaps first
        Collections.sort(swapList);
        long cost = 0;
        int m = swapList.size();
        for (int i = 0; i < m / 2; i++) {
            // Either direct swap or use two minElement swaps
            cost += Math.min(swapList.get(i), 2 * minElement);
        }

        return cost;
    }
}


