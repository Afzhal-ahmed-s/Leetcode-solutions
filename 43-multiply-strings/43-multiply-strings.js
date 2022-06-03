/**
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    let n1=num1.length, n2=num2.length;
if (num1== '0' || num2== '0')return '0';
let result= new Array(n1 + n2).fill(0);

    for(let i=n1-1;i>=0;i--){
        
        //carry=0;
        
        for(let j=n2-1;j>=0;j--){
            let carry= i+j, curr=i+j+1;
            let sum= result[curr] + num1[i]*num2[j];
            result[curr]= sum%10;
            result[carry]+= Math.floor(sum/10);
        }
        //console.log(result);
    }
    if(result[0]==0)result.shift();
    return result.join("");
}