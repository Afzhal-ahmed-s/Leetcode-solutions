/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    let obj= {'0':0, '1':1, '2':4, '3':9, '4':16, '5':25, '6':36, '7':49, '8':64, '9':81};
    
    let set= new Set();
    let sum=0;
    while(!set.has(n))
        {
        set.add(n);
         let str= n.toString();   
         n=0;
           // console.log(str);
    for(let c of str)
        {
          n+= obj[c];  
        }
    console.log(n);
    if(n==1)return true;
        }
    
    return false;
};