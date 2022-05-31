/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {

    if(n<1)return false;
    
    let slow=n,fast=run(n);
    while(slow!==fast && slow!==1){
        slow=run(slow);
        fast=run(run(fast));
    }
    if(slow===1)return true;
    console.log(slow,fast)
    return (slow!==fast);
    
    function run(num){
        return num.toString().split("").map(x=>(+x)**2).reduce((ans,x)=>ans+x)
    }
};