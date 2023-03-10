class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len= nums.length;
        if(len==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        
        int l=0, r=1;
        
        for(int a=0; a<len; a++)System.out.print(nums[a]+" ");
        
        while(r<len){
            if(nums[l] != nums[r])return nums[l];
            if(r+2 == len)return nums[len-1];
            l+=2; r+=2;
        }
        return -1;
    }
}