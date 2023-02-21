class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int r=0;
        
        for(int l=0; l<len; l++){
            if(nums[l] != nums[r])nums[++r] = nums[l];
        }

        return ++r;
    }
}