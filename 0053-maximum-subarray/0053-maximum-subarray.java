class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int length = nums.length;
        
        for(int i=0; i<length; i++){
            sum += nums[i];
            
            if(max < sum)max= sum;
            
            if(sum < 0)sum=0;
        }
        return max;
        
    }
}