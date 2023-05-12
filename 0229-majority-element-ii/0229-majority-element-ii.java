class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int length = nums.length;
        int count1 = 0; int el1 = Integer.MIN_VALUE; int count2 = 0; int el2 = Integer.MIN_VALUE; 
        List<Integer> ans = new ArrayList<>();
        
        
        for(int i=0; i<length; i++){
            if(count1 == 0 && nums[i] != el2){
                count1++;
                el1 = nums[i];
            }
            else if(count2 == 0 && nums[i] != el1){
                count2++;
                el2 = nums[i];
            }
            else if(nums[i] == el1)count1++;
            else if(nums[i] == el2)count2++;
            else{
                count1--;
                count2--;
            }
        }
        
        count1 = 0; count2 = 0;
        
        for(int i=0; i<length; i++){
            if(nums[i] == el1)count1++;
            else if(nums[i] == el2)count2++;
        }
        
        if(count1 > length/3)ans.add(el1);
        if(count2 > length/3)ans.add(el2);
        
        
        return ans;
        
    }
}