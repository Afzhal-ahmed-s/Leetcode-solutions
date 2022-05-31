/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let firstrow=false,firstcol=false;
    let rows=matrix.length, cols=matrix[0].length;
    
    for(let i=0;i<cols;i++){
        if(matrix[0][i]==0){
            firstrow=true;
            break;
        }
    }
    
      for(let i=0;i<rows;i++){
        if(matrix[i][0]==0){
            firstcol=true;
          break;
        }
    }
    
    for(let i=1;i<rows;i++){
        for(let j=1;j<cols;j++){
            if(matrix[i][j]==0){
                matrix[i][0]=0;
                matrix[0][j]=0;
            }
        }
    }
    
    for(let i=1;i<rows;i++){
        for(let j=1;j<cols;j++){
            if(matrix[0][j]==0 || matrix[i][0]==0){
               matrix[i][j]=0;
            }
        }
    }
    
    if(firstrow){
        matrix[0]=matrix[0].map(x=>x*0);
    }
    
    if(firstcol){
        for(let i=0;i<rows;i++){
            matrix[i][0]=0;
        }
    }
    return matrix;
};