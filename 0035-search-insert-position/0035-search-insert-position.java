class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int len = nums.length;
        int s=0, e= len-1;
        
        // 0,1,2,3   len=4, t=7
        // 1,3,5,6
        
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