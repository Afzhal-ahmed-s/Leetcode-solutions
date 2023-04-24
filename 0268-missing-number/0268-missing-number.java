class Solution {
    public int missingNumber(int[] nums) {
        
        int totalSum = 0;
        int sumOfNumbers = 0;
        int n = nums.length;
        
        for(int i=1; i<=n; i++){
            totalSum += i;
            sumOfNumbers += nums[i-1];
        }
        
        return (totalSum - sumOfNumbers);
        
    }
}