class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        if(x!=0 && x/10 == 0)return true;
        if(x!=0 && x%10 == 0)return false;
        
        int revNum = 0;
        int n = x;
        
        while(n > revNum){
            
            int lastDigit = n%10;
            revNum = revNum*10 + lastDigit;
            n= n/10;
        }
        //System.out.println("check: "+ n+", "+revNum);
        return (n == revNum || n == revNum/10) ? true : false;
        
       
    }
}