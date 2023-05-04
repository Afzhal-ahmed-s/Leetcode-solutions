class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        
        for(int i=0; i<length; i++){
             for(int j=i; j<length; j++){
                 int temporary = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temporary;
             }
        }
        
        for(int i=0; i<length; i++){
             int l=0; int r = length-1;
            
             while(l < r){
                 int temporary = matrix[i][l];
                 matrix[i][l] = matrix[i][r];
                 matrix[i][r] = temporary;
                 l++; r--;
             }
        }
        
    }
}