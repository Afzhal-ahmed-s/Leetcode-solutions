class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        ans.add( Arrays.asList(1) );
        if(numRows == 1)return ans;
        ans.add( Arrays.asList(1, 1) );
        if(numRows == 2)return ans;
        
        for(int i=2; i<numRows; i++){
            int previousRow = i-1;
            List<Integer> local = new ArrayList<>();
            List<Integer> previousRowList = ans.get(previousRow);
            //System.out.println("Check: "+previousRowList);
            for(int j=0; j<=i; j++){
                if(j==0 || j== i)local.add(1);
                else{
                    local.add( previousRowList.get(j-1) + previousRowList.get(j) );
                }
            }
            ans.add(local);
        }
        
        return ans;
    }
}