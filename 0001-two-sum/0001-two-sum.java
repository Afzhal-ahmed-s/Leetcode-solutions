class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
         for(int a=0; a<len-1; a++){
             for(int b=a+1; b<len; b++){
                 if(nums[a] + nums[b] == target)return new int[]{a,b};
             }
         }
         return new int[]{};
    }
}