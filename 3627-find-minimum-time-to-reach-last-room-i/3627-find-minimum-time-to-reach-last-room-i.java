class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int dx = 1, dy = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        heap.add(new int[]{0, 0, 0});

        Set<String> unseen = new HashSet<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                unseen.add(i + "," + j);

        unseen.remove("0,0");

        while (!heap.isEmpty()) {
            int[] current = heap.poll();
            int time = current[0], x = current[1], y = current[2];

            if (x == m - 1 && y == n - 1) return time;

            for (int i = 0; i < 4; i++) {
                int temp = dx;
                dx = dy;
                dy = -temp;
                int X = x + dx, Y = y + dy;

                String pos = X + "," + Y;
                if (unseen.contains(pos)) {
                    int t = Math.max(time, moveTime[X][Y]) + 1;
                    heap.add(new int[]{t, X, Y});
                    unseen.remove(pos);
                }
            }
        }

        return -1;}
}