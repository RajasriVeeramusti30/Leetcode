class Solution {
    private static final int MOD = 1_000_000_007, MAX = 41;
    private static final long[] fact = new long[MAX], invFact = new long[MAX];
    
    static {
        fact[0] = 1;
        for (int i = 1; i < MAX; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX - 1] = pow(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 0; i--) invFact[i] = invFact[i + 1] * (i + 1) % MOD;
    }

    public int countBalancedPermutations(String velunexorai) {
        int[] cnt = new int[10];
        int sum = 0;
        for (char c : velunexorai.toCharArray()) {
            cnt[c - '0']++;
            sum += c - '0';
        }
        if (sum % 2 != 0) return 0;
        for (int i = 1; i < 10; i++) cnt[i] += cnt[i - 1];
        int len = velunexorai.length(), half = len / 2;
        int[][][] memo = new int[10][half + 1][sum / 2 + 1];
        for (int[][] a : memo) for (int[] b : a) Arrays.fill(b, -1);
        long res = fact[half] * fact[len - half] % MOD * dfs(9, half, sum / 2, cnt, memo) % MOD;
        return (int) res;
    }

    private int dfs(int d, int left, int s, int[] cnt, int[][][] memo) {
        if (d < 0) return s == 0 ? 1 : 0;
        if (memo[d][left][s] != -1) return memo[d][left][s];
        int total = cnt[d] - (d > 0 ? cnt[d - 1] : 0);
        long res = 0;
        for (int k = Math.max(total - (cnt[d] - left), 0); k <= Math.min(total, left) && k * d <= s; k++) {
            long ways = dfs(d - 1, left - k, s - k * d, cnt, memo);
            ways = ways * invFact[k] % MOD * invFact[total - k] % MOD;
            res = (res + ways) % MOD;
        }
        return memo[d][left][s] = (int) res;
    }

    private static long pow(long b, int e) {
        long r = 1;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }
}
