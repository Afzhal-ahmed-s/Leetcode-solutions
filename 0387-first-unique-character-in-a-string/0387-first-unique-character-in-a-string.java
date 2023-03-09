class Solution {
    public int firstUniqChar(String s) {
        int[]charArr = new int[26];
        int len = s.length();
        
        for(int a=0; a<len; a++){
            char c= s.charAt(a);
            charArr[c-'a']++;
        }
        
        for(int a=0; a<len; a++){
            if(charArr[s.charAt(a) - 97] ==1)return a;
        }
        return -1;
    }
}