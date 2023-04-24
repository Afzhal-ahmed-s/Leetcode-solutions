class Solution {
    public int missingNumber(int[] nums) {
        
        int sumOfNumbers = 0;
        int n = nums.length;
        
        for(int e : nums)sumOfNumbers += e;
        
        return ( ((n*(n+1))/2) - sumOfNumbers);
        
    }
}