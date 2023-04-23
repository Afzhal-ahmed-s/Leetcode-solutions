class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer = 1;
        int insertionPointer = 0;
        int length = nums.length;
        
        while(pointer < length){
            if(nums[pointer] != nums[insertionPointer]){
                nums[++insertionPointer] = nums[pointer];
            }
            
            ++pointer;
        }
        
        return ++insertionPointer;     
    }
}