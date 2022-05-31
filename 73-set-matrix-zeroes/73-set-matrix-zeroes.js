/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function(matrix) {
    let row=new Set(),col=new Set();
    let m=matrix.length, n=matrix[0].length;
    
    for(let i=0;i<m;i++){
        for(let j=0;j<n;j++){

            if(matrix[i][j]==0){
                row.add(i);
                col.add(j);
            }
        }
    }

    for(let i=0;i<m;i++){
        if(row.has(i))matrix[i]=matrix[i].map(x=>x*0);
    }
    
    for(let i=0;i<n;i++){
        for(let j=0;j<m;j++){
            if(col.has(i)){
               matrix[j][i]=0;
            }
        }
    }
    
    return matrix;
};