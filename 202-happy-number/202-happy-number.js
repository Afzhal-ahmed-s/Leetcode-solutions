/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    if(n<=0)return false;
    let str;
    let sum=0;
    let flag=true;
    let set= new Set();
    // console.log(" "+n);
    while(!set.has(sum))
        {
            set.add(sum);
            if(flag==false)
            {
                str= '' + sum;
                sum=0;
            }
            if(flag==true)
                {
                    str='' + n;
                    flag=false;
                }
            
            for(let c of str)
                {
                    c= +c;
                    // console.log("c: ",c);
                    sum+= c*c;
                    // console.log("sum",sum);
                }
            //console.log("str",str);
            console.log("sum",sum);
            if(sum==1)return true;
            if(sum==n)return false;
        }
    return false;
};