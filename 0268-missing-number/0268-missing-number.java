class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum=0;
            
        for(int e : nums)sum+=e;
        
        return ((len* (len+1))/2) - sum;
        
    }
}