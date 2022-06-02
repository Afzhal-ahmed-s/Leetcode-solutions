/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
// var myPow = function(x, n) {
//     return x**n;
// };
var myPow = function(a, b) {

    if(b==0)return 1;
    else if(b==1)return a;
    else if(b==-1)return 1/a;
    if(b%2==0){
        let t= myPow(a,b/2);
        return t*t;
    }
    if(b%2!=0){
        return a* myPow(a,b-1);
    }
};