class Solution {
    public List<List<Integer>> permute(int[] nums) {
     List<List<Integer>> answer = new ArrayList<List<Integer>>();
        int index = 0;
        backTrack(index, nums, answer);
        return answer;
    }
    
    public static void backTrack(int index, int[] nums, List<List<Integer>> answer){
        
        if(index == nums.length){
        List<Integer> tempList = new ArrayList<>();
            
        for(int c : nums)tempList.add(c);
            answer.add(tempList);
        }
        
        for(int j=index; j<nums.length; j++){
            //swapping logic
            {
                int temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
            }
            backTrack(index + 1, nums, answer);
              //swapping logic
            {
                int temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
            }
        }
        
    }
    
}