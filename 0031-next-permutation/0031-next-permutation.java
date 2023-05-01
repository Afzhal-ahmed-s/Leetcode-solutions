class Solution {
    public void nextPermutation(int[] nums) {
     int index = -1;
     int length = nums.length;
        
     for(int i= length-2; i>=0; i--){
         if(nums[i] < nums[i+1]){
            index = i;
             break;
         }
     }   
        
     if(index == -1){
         customReverse(nums, 0, length-1);
     }
     
     else
     {
         
     for(int i= length-1; i > index; i--)
     {
         if(nums[index] < nums[i]){
             swap(nums, index, i);
             break;
         }
     }   
        
     customReverse(nums, index+1, length-1);  
     
     }    
        
    }
    
    public void swap(int[] nums, int l, int r){
        int temporary = nums[l];
        nums[l] = nums[r];
        nums[r] = temporary;
    }
    
    public void customReverse(int[] arr, int l, int r){

        while(l < r){
            swap(arr, l, r);
            l++; r--;
        }
    }
}