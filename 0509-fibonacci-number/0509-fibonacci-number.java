class Solution {
    public int fib(int n) {
        if(n==0)return 0; if(n==1)return 1;
        
        int nMinusTwo = 0;
        int nMinusOne = 1;
        
        return helper(nMinusTwo, nMinusOne, 2, n);
    }
    
    public int helper(int nMinusTwo, int nMinusOne, int current, int n){
        if(current == n){
            return (nMinusTwo + nMinusOne);
        }
        
        return helper(nMinusOne, (nMinusOne + nMinusTwo), ++current, n);
    }
}