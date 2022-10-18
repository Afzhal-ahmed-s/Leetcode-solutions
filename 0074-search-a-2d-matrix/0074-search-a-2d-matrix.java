class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rowConstrains = matrix.length;
        int colConstrains = matrix[0].length;
        
        int l =0;
        int r = (rowConstrains * colConstrains) -1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            
            int element = matrix[mid/colConstrains][mid%colConstrains];
            
            if(element == target)return true;
            
            else if(element < target) l = mid +1;
            else r = mid -1;
        }
        return false;
}
}