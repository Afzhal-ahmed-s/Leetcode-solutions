class Solution {
    public int majorityElement(int[] nums) {
        int len= nums.length, l=0, r=1;
        if(len==1 || len==2)return nums[0];
        
        Arrays.sort(nums);
        int count=1; int bloodySweet = 0;
        if(len%2==0) bloodySweet = len/2;
        else bloodySweet = (len/2) + 1;
        
        while(l<=r && r<len){
          if(nums[l] == nums[r]){
              while(r<len && nums[l]==nums[r]){
                  count++;
                  r++;
              }
           if(count >= bloodySweet)return nums[l]; 
        }
          count=1;
          l=r; r=l+1;  
    }
       return -1; 
}
}