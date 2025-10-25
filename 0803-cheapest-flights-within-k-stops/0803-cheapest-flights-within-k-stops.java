import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        // Min cost to each node
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        // Queue holds [node, cost, stops]
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k) continue;

            if (!adj.containsKey(node)) continue;

            for (int[] neighbor : adj.get(node)) {
                int nextNode = neighbor[0];
                int price = neighbor[1];
                int newCost = cost + price;

                if (newCost < minCost[nextNode]) {
                    minCost[nextNode] = newCost;
                    q.offer(new int[]{nextNode, newCost, stops + 1});
                }
            }
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
