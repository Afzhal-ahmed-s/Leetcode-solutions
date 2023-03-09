class Solution {
    public int strStr(String haystack, String needle) {
        int hlen= haystack.length(), nlen= needle.length();
        
        for(int a=0; a<hlen; a++){
            if(haystack.charAt(a)==needle.charAt(0)){
                if(hlen-a >= nlen){
                    if(haystack.substring(a,a+nlen).equals(needle))return a;
                }
            }
        }
        return -1;
    }
}