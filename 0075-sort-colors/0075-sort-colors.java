class Solution {
    public void sortColors(int[] nums) {
        
       int zero = 0; int one = 0; int two=0; int n= nums.length;
        
       for(int i=0; i<n; i++){
            if(nums[i]==0)zero++;
            else if(nums[i]==1)one++;
            else two++;
        }
       int index = 0;       
       
       while(zero > 0 && index < n){
           nums[index++] = 0;
           zero--;
       }
       while(one > 0 && index < n){
           nums[index++] = 1;
           one--;
       }
       while(two > 0 && index < n){
           nums[index++] = 2;
           two--;
       }
        
    }
}