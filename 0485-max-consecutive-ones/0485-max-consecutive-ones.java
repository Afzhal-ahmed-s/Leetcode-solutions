class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int length = nums.length;
        int maxCount = Integer.MIN_VALUE;
        
        for(int i=0; i<length; i++){
            int count = 0;
            while(i<length && nums[i]==1){
                count++;
                maxCount = Math.max(count, maxCount);
                i++;
            }
        }
        return (maxCount == Integer.MIN_VALUE) ? 0 : maxCount;
    }
}