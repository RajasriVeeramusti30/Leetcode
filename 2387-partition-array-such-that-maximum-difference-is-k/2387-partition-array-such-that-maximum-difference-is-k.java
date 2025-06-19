class Solution {
    public int partitionArray(int[] nums, int k) {
         Arrays.sort(nums);
        int count = 0, start = 0;
 
        for (int i = 0; i < nums.length; i++) {
             
            if (nums[i] - nums[start] > k) {
               
                count++;  
                start = i; 
            }
        }

        // 6. Don't forget to count the last subsequence! We always need to count the last group. \U0001f381
        count++;

        // 7. Return the total number of subsequences. That's the answer! \U0001f3c6
        return count;
    }
}