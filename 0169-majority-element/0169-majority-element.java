class Solution {
    public int majorityElement(int[] nums) {
        
        int len = nums.length;
        Map map = new HashMap<Integer, Integer>();
        
        for(int e : nums){
            map.put(e, (int)map.getOrDefault(e, 0) + 1);
            if((int)map.get(e) > len/2)return e;
        };
        
        return -1;
        
    }
}