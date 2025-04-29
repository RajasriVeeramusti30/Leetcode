 class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long ans = 0;
        int count = 0;
        int left = 0;
        
       
        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                count++;
            }
            
           
            while (count >= k) {
                if (nums[left] == max) {
                    count--;
                }
                left++;
            }
            
            ans += left;
        }
        
        return ans;
    }
}