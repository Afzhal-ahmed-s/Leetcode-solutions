class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int length = nums.length;
        List<Integer> ans = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<length; i++)map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        
        for(Map.Entry<Integer, Integer> e : set){
            if(e.getValue() > length/3)ans.add( (int) e.getKey());
        }
        
        return ans;
        
    }
}