class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int l=0; int r=len-1;
        
        while(l<r){
            char cr = s[r], temp= s[l];
            s[r--]=temp;
            s[l++]=cr;
        }
    }
}