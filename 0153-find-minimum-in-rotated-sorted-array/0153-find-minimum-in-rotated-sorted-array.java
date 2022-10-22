class Solution {
    public int findMin(int[] nums) {
        
        int s = 0;
        int e = nums.length -1;
        int res = nums[0];
        
        while(s <= e){
            
            if(nums[s] < nums[e]){
                res = Math.min(res, nums[s]);
                break;
            }
            
            int mid = s + (e - s)/2;
            
            res = Math.min(res, nums[mid]);
            
            if(nums[mid] >= nums[s]) s = mid +1;
            else e = mid - 1;
            
        }
        return res;
    }
}