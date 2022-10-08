class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        int runNum = 0;
        backTrack(index, runNum, temp, candidates, answer, target);
        return answer;
    }
    
    public static void backTrack
        (int index, int runNum, List<Integer> temp, int[] candidates, List<List<Integer>> answer, int target)
    {
        if(runNum == target){
            answer.add(new ArrayList(temp));
            return;
        }
        else if(index == candidates.length || runNum > target){
            return;
        }
        else{
            temp.add(candidates[index]);
            backTrack(index+1, runNum+candidates[index] , temp, candidates, answer, target);
            temp.remove(temp.size()-1);
            while(index < candidates.length-1 && candidates[index]==candidates[index+1]){
                index++;
            }
            backTrack(index+1, runNum , temp, candidates, answer, target);
        }
    }
}