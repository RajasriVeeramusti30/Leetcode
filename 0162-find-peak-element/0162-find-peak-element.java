class Solution {
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int peak=0;
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i])
            peak = i;
        }
        return peak;
    }
}