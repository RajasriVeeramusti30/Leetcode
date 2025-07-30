class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = nums[0];
        for(int n:nums){
            maxValue = Math.max(maxValue,n);
        }
        int curr = 0,maxLengthFound=0;
        for(int n:nums){
            if(n==maxValue){
                curr++;
                maxLengthFound = Math.max(maxLengthFound,curr);
            }
            else{
                curr=0;
            }
        }
        return maxLengthFound;
    }
}