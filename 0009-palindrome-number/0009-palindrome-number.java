class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)return false;
        if(x!=0 && x/10 == 0)return true;

        int revNum = 0;
        int n = x;
        while(n > 0){
                    //System.out.println(n+" - "+revNum);
            
            int lastDigit = n%10;
            revNum = revNum*10 + lastDigit;
            n= n/10;
        }
        //System.out.println("Outside: "+n+" - "+revNum);

        return (x == revNum) ? true : false;
        
       
    }
}