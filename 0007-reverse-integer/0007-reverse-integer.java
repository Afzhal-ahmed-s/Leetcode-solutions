class Solution {
    public int reverse(int x) {
        
        int n = Math.abs(x);
        long ans = 0;
        boolean endNumber = false;
        boolean negative = false;
        
        if(x < 0)negative = true;
        
        while(n > 0){
            int temp = n%10;
            n = n/10;
            if(endNumber==false && temp != 0)endNumber = true;
            if(endNumber)ans = (ans * 10) + temp;
        }
        
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)return 0;
       return (negative == true) ? (int)-ans : (int)ans;
    }
}