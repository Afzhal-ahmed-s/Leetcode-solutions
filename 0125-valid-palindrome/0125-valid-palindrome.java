class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1)return true;
        
        String str = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int l=0, r=str.length()-1;
        
        while(l<r){
            Character cl = str.charAt(l); Character cr = str.charAt(r);
            if(cl!=cr)return false;
            l++; r--;
        }
        return true;
    }
}