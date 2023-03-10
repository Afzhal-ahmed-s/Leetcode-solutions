class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int a=1; a<=numRows; a++){
            List<Integer> local = new ArrayList<>();
           
            for(int b=1; b<=a; b++){
                if(b==1 || b==a)local.add(1);
                else{
                    List<Integer> tempList = ans.get(a -1 -1);
                    int insertionNum = tempList.get(b-1-1) + tempList.get(b-1);
                    local.add( insertionNum );
                }
            }
            
            ans.add(local);
        }
        
        return ans;

    }
}