class Solution {
    public int[] rearrangeArray(int[] nums) {
        int even=0;
        int odd=1;
        int n=nums.length;
        int[] res=new int[n];
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            if(a==0||a>0){
                res[even]=a;
                even=even+2;
            }
            else{
                res[odd]=a;
                odd=odd+2;
            }
        }
        return res;

    }
}