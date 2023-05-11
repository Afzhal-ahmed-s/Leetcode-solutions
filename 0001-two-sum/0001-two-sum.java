class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length;
        
        Map map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<len; i++){
            int compliment = target - nums[i];
            
            if(map.containsKey(compliment))return new int[]{(int)map.get(compliment), i};
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}