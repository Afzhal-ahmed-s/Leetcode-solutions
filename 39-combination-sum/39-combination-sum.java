class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        int index = 0;
        
        generateCS(index, temp, answer, candidates, target);
        return(answer);
    }
    
    public static void generateCS(int index, List<Integer> temp, List<List<Integer>> answer, int[] candidates, int target){
        
        if(target == 0){
            answer.add(new ArrayList<>(temp));
        }
          else if(target < 0 || index >= candidates.length){
            return;
          }
        else{
            temp.add(candidates[index]);
            generateCS(index, temp, answer, candidates, target - candidates[index]); 
            temp.remove(temp.size()-1);
            generateCS(index+1, temp, answer, candidates, target); 
        }
    }
}

