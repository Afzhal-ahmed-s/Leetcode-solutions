class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> rowOne = Arrays.asList(1);
        List<Integer> rowTwo = Arrays.asList(1,1);

        
        if(numRows == 1){
            ans.add(rowOne); return ans;
        }
        if(numRows == 2){
            ans.add(rowOne); ans.add(rowTwo); return ans;
        }
        
        for(int a=1; a<=numRows; a++){
            List<Integer> local = new ArrayList<>();
            if(a==1 || a==2){
                for(int b=1; b<=a; b++)local.add(1);
            }
            else{
            for(int b=1; b<=a; b++){
                if(b==1 || b==a)local.add(1);
                else{
                    //System.out.println("a- "+a+" "+(a-1-1));
                    List<Integer> tempList = ans.get(a -1 -1);
                    //System.out.println("b- "+ (b-1-1)+" "+(b-1));
                    int insertionNum = tempList.get(b-1-1) + tempList.get(b-1);
                    local.add( insertionNum );
                }
            }    
            }
            
            ans.add(local);
        }
        
        return ans;

    }
}