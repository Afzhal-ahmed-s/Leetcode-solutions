class Solution {
    public boolean exist(char[][] board, String word) {
        int rows= board.length;
        int cols= board[0].length;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int curr = 0;
                boolean isThere = backTrack(i, j, rows, cols, board, word, curr);
                if(isThere)return true;
            }
        }
        return false;
    }
    
    public static boolean backTrack(int i, int j, int rows, int cols, char[][] board, String word, int curr){
        boolean isPresent = false;
        
        if(curr == word.length())return true;
        
        else if(i == rows || j == cols || i<0 || j<0 || board[i][j]!=word.charAt(curr))return false;
        
        else{
            if(board[i][j] == word.charAt(curr)){
               board[i][j] += 100; 
            
            isPresent = (
                backTrack(i+1, j, rows, cols, board, word, curr+1) ||
                backTrack(i, j+1, rows, cols, board, word, curr+1) ||
                backTrack(i-1, j, rows, cols, board, word, curr+1) ||
                backTrack(i, j-1, rows, cols, board, word, curr+1)
            );
            board[i][j] -= 100; 
        }
        }
        return isPresent;
    }
}