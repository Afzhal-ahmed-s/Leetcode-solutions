class Solution {
    public void sortColors(int[] nums) {
        
       int length = nums.length; 
       int low =0; int mid = 0; int high= length-1;
        
       while(mid <= high){
           if(nums[mid] == 0){
               swap(nums, low, mid);
               low++;
               mid++;
           }
           else if( nums[mid] == 2 ){
               swap(nums, mid, high);
               //mid++;
               high--;
           }
           else mid++;
       } 
        
    }
    
    public void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}