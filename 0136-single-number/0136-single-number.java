class Solution {
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int ans = nums[0];
        
        for(int i=1; i<length; i++){
            ans = ans ^ nums[i];
        }
        
        return ans;
    }
}