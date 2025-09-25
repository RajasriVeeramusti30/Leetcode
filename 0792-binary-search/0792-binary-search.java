class Solution {
    public int search(int[] arr, int target) {
        int n= arr.length;
        int left = 0 ; 
        int right = n-1;
        while(left<=right){
            int mid = (right-left)/2 + left;
            if(arr[mid] == target) return mid;
            else if(arr[mid]>target) right = mid-1;
            else left = mid+1;
        }
        return -1;
    }
}