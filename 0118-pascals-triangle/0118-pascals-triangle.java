class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();

        for(int a=1; a<=numRows; a++){
            List<Integer> locall = new ArrayList<>();
           
            for(int b=1; b<=a; b++){
                if(b==1 || b==a)locall.add(1);
                else{
                    List<Integer> tempList = ans.get(a -1 -1);
                    int insertionNum = tempList.get(b-1-1) + tempList.get(b-1);
                    locall.add( insertionNum );
                }
            }
            
            ans.add(locall);
        }
        
        return ans;

    }
}