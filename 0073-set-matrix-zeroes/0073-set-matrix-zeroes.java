class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        boolean junction = true;
        boolean row = true;
        boolean col = true;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    if(i==0 && j==0)junction = false;
                    else if(i == 0)row = false;
                    else if(j == 0)col =false;
                    else{
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;                        
                    }
                    
                }
            }
        }
        
        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                matrix[i][j] = 0;
                }
            }
        }
       
        if(!junction){
            for(int j=0; j<cols; j++)matrix[0][j] = 0;
            for(int i=0; i<rows; i++)matrix[i][0] = 0;
        }
        else{
            
        if(!row){
            for(int j=0; j<cols; j++)matrix[0][j] = 0;
        }
        
        if(!col){
            for(int i=0; i<rows; i++)matrix[i][0] = 0;
        }
        
        }    
    }
}