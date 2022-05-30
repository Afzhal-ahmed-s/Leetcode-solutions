/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
//   if (n === 1) return true;
  
//   let tortoise = n, hare = getNext(n);
//   while (hare !== 1 && tortoise !== hare) {
//     tortoise = getNext(tortoise);
//     hare = getNext(getNext(hare));
//   }
  
//   return tortoise !== hare;
        
//   function getNext(n) {
//     return (n + '').split('').map(num => (num - 0)**2).reduce((sum, num) => sum += num)
//   }
    
    let cur = n, curSet = new Set();
  while (cur !== 1 && !curSet.has(cur)) {
    curSet.add(cur)
    cur = (cur + '').split('').map(num => (num - 0)**2).reduce((sum, num) => sum += num);
  }
  return cur === 1;
};