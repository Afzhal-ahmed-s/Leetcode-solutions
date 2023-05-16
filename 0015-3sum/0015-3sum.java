class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        int length = nums.length;
        int l=0; int r= length-1;
        
        Arrays.sort(nums);
        
        for(int i=0; i<length-2; i++){
            
            if(i - 1 >= 0 && nums[i] == nums[i-1])continue;
            
            l= i+1;
            r = length-1;
            
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0){
                    List<Integer> local = new ArrayList<>();

                    local.add(nums[i]); local.add(nums[l]); local.add(nums[r]);
                    ans.add(local);
                    System.out.println(i);

                   // local.clear();
                    //System.out.println(nums[i]+", "+nums[l]+", "+nums[r]);
                    while( l<r && nums[l] == nums[l+1])l++;
                    while( l<r && nums[r] == nums[r-1])r--;
                    
                    l++; r--;
                }
                else if(nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }
                else r--;
            }

        }
        
        return ans;
        
    }
}