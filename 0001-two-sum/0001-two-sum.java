//TC: O(N)
//SC: O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        
        Map map = new HashMap<Integer, Integer>();
        int l=0; int r=0;
        
        for(int a=0 ;a<len; a++){
            if(map.size()==0){
                map.put(nums[a], a);
            }
            else if(map.size()!=0){
                int comp = target - nums[a];
                if(map.containsKey(comp)){
                    l= (int)map.get(comp);
                    r= a;
                    break;
                }
                else{
                    map.put(nums[a], a);
                }
            }
        }
        return new int[]{l, r};
    }
}