class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] arr = new int[n][2]; // [value, index]

        // \U0001f9f1 Step 1: Store value + index
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // \U0001f53d Step 2: Sort descending by value to pick top-k
        Arrays.sort(arr, (a, b) -> Integer.compare(b[0], a[0]));

        // \U0001f53c Step 3: Re-sort top-k by original index
        Arrays.sort(arr, 0, k, (a, b) -> Integer.compare(a[1], b[1]));

        // \U0001f3af Step 4: Collect values of selected elements
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i][0];
        }

        return res;
    }
}