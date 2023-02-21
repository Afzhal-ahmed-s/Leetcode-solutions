class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int len = digits.length;
        
        for(int i=len-1; i>=0; i--){
            int temp=0;
            if(i==len-1)temp = digits[i] + 1 + carry;
            else temp = digits[i] + carry;
            
            if(temp < 10){
                digits[i] = temp;
                carry = 0;
            }
            else{
                carry = temp/10;
                digits[i] = temp%10;
            }
        }
        if(carry == 0)return digits;
        else{
            int[] ans = new int[len+1];
            ans[0]= carry;
            for(int i=1; i<len+1; i++){
                ans[i] = digits[i-1];
            }
            return ans;
        }
    }
}