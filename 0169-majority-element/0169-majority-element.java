class Solution {
    public int majorityElement(int[] nums) {
        int len= nums.length, l=0, r=1;
        if(len==1 || len==2)return nums[0];
        
        Arrays.sort(nums);
        int count=0; int bloodySweet = 0;
        if(len%2==0)bloodySweet = len/2;
        else bloodySweet = (len/2) + 1;
        //System.out.println(bloodySweet);
        //[2,3,3]
        //[1,1,1,2,2,2,2]
        
        while(l<=r && r<len){
            //System.out.println("check: "+l+" "+r);
          if(nums[l] == nums[r]){
            //System.out.println("check2: "+l+" "+r);              
              count++;
              while(r<len && nums[l]==nums[r]){
                  count++;
                  r++;
              }
           if(count >= bloodySweet)return nums[l]; 
        }
            count=0;
          l=r; r=l+1;  
    }
       return -1; 
}
}