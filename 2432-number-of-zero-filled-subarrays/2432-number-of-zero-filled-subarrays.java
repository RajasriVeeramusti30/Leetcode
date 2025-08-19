class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0,run=0;
        for(int x :nums){
            if(x==0){
                run +=1;
                ans += run;
            }
                else{
                    run=0;
            }
        }
        return ans;
    }
}