class Solution {
    public boolean isPalindrome(String s) {
        String alteredString = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        
        return helper(0, alteredString.length()-1, alteredString);
    }
    public boolean helper(int left, int right, String alteredString){
        if(left >= right)return true;
        if(alteredString.charAt(left) != alteredString.charAt(right))return false;
        
        return helper(++left, --right, alteredString);
    }
}