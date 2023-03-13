class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int len = nums.length;
        int s=0, e= len-1;
        
        while(s <= e){
            int mid = e - (e-s)/2;
            if(nums[mid]==target)return mid;
            else if(nums[mid] < target){
                s = mid+1;
            }
            else e = mid -1;
        }
        return s;
    }
}