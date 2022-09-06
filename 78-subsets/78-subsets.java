class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int indexOfPointer = 0;
        List<Integer> temporary = new ArrayList<>();
        
        backTrack(result, temporary, nums, indexOfPointer);
        return result;
    }
    
    public static void backTrack(List<List<Integer>> result
            , List<Integer> temporary, int[] nums, int index )
    {
     if(index == nums.length){
         result.add(new ArrayList<>(temporary));
     }
        else{
            //include
            temporary.add(nums[index]);
            backTrack(result, temporary, nums, index+1);
            //exclude
            temporary.remove(temporary.size() -1);
            backTrack(result, temporary, nums, index+1);
        }
    }
    
}