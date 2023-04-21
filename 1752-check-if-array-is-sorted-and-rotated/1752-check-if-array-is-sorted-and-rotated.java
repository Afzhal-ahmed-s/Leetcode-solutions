class Solution {
    public boolean check(int[] nums) {
        boolean ans = false;
        boolean intiallySorted = true;
        int length = nums.length;
        int count=0;
        
        for(int i=0; i<length-1; i++){
            if(i+1 <= length-1 && nums[i] > nums[i+1]){
                intiallySorted = false;
                count++;
            }
        }
        System.out.println(count);
        if(intiallySorted)return true;
        if(count > 1)return false;
        
        int firstStart= nums[0]; int firstEnd; int secondStart; int secondEnd;
        
        for(int i=1; i<length; i++){
            if(nums[i-1] > nums[i])
            {
                firstEnd = nums[i-1];
                secondStart = nums[i];
                secondEnd = nums[length - 1];
                if(firstStart >= secondEnd && secondStart <= firstStart && firstEnd >= secondEnd)ans = true;
                break;
            }
        }
        
        return ans;
        
    }
}