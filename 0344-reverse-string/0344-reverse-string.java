class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int l=0; int r=len-1;
        
        while(l<r){
            char cl = s[l], cr= s[r];
            s[r--]=cl;
            s[l++]=cr;
        }
    }
}