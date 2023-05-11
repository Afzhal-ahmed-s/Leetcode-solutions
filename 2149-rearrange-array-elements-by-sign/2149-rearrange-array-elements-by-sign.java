class Solution {
    public int[] rearrangeArray(int[] nums) {
        int positivePointer = 0;
        int negativePointer = 0;
        int length = nums.length;
        int[] ans = new int[length];
        int positiveInsertionPointer = 0;
        int negativeInsertionPointer = 1;
        
        while(positivePointer < length && negativePointer < length){
            while(positivePointer < length && nums[positivePointer] < 0 ){
                positivePointer++;
            }
            while(negativePointer < length && nums[negativePointer] > 0 ){
                negativePointer++;
            }

            insert(ans, nums, positivePointer, negativePointer, positiveInsertionPointer, negativeInsertionPointer);
             positiveInsertionPointer += 2;
             negativeInsertionPointer += 2;
                positivePointer++;
                negativePointer++;
        }
        return ans;
    }
    
    public void insert (int[] ans, int[] nums, int positivePointer, int negativePointer, int positiveInsertionPointer, int negativeInsertionPointer){
        ans[positiveInsertionPointer] = nums[positivePointer];
        ans[negativeInsertionPointer] = nums[negativePointer];
       
    }
}