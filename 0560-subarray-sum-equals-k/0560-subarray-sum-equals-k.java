class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int length = nums.length;
        Map map = new HashMap<Integer, Integer>();
        int count = 0;
        int sum = 0;
        
        map.put(0, 1);
        
        for(int i=0; i<length; i++){
         sum += nums[i];

         int compliment = sum - k;
            
         if(map.containsKey(compliment)){
             count += (int)map.get(compliment);
         }   
         map.put(sum, (int)map.getOrDefault(sum, 0) + 1 );   
        }
        
        return count;
    }
}