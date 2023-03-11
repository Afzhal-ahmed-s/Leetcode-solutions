class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum= (nums.length* (nums.length+1))/2;
            int sum=0;
            
        for(int e : nums)sum+=e;
        
        return expectedSum-sum;
        
    }
}