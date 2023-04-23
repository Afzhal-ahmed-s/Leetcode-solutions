class Solution {
    public void rotate(int[] nums, int k) {
        
        int length = nums.length;
        int numberOfRotations = k%length;
        
        if(k < 0)k = k + length;
        
        reverse(nums, 0, length - numberOfRotations - 1);
        reverse(nums, length - numberOfRotations, length - 1);
        reverse(nums, 0, length - 1);
        
    }
    
    public void reverse(int[] nums, int left, int right){
        int i = left; int j = right;
        
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }

}