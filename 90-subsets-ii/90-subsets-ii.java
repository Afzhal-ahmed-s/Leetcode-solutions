class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList();
        List<Integer> temporary = new ArrayList<>();
        int depth = 0;
        backTrack(nums, temporary, depth, answer);
        return (answer);
    }
    
    public static void backTrack(
        int[] nums, List<Integer> temporary, int depth, List<List<Integer>> answer)
    {
        if(depth == nums.length){
            answer.add(new ArrayList(temporary)); 
            return;
        }
        else{
            temporary.add(nums[depth]);
            backTrack(nums, temporary, depth+1, answer);
            temporary.remove(temporary.size()-1);
            while(depth < nums.length -1 && (nums[depth]==nums[depth+1])){
                depth++;
            }
            backTrack(nums, temporary, depth+1, answer);
        }
    }
}