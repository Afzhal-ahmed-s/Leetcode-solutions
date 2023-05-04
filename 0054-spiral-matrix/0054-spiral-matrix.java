class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        
        int sr=0; int er= matrix.length-1; 
        int sc = 0; int ec = matrix[0].length-1;
        
        while(sr <= er && sc <= ec){
            
            for(int i= sc; i<=ec; i++){
                list.add(matrix[sr][i]);
            }
            sr++;
            
            if(sr <= er && sc <= ec){
            for(int i= sr; i<=er; i++){
                list.add(matrix[i][ec]);
            }
            ec--;
            }
            else continue;
            
            if(sr <= er && sc <= ec){
            for(int i= ec; i>=sc; i--){
                list.add(matrix[er][i]);
            }
            er--;
            }
            else continue;
            
            for(int i= er; i>=sr; i--){
                list.add(matrix[i][sc]);
            }
            sc++;
            
        }
        
        return list;
        
    }
}