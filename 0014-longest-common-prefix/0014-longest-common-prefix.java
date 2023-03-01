class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==0)return "";
        int lenStr1 = strs[0].length();
        char[] firstString = strs[0].toCharArray();
        int firstStringLen = firstString.length;
        if(firstStringLen==0)return "";
        int ans = Integer.MAX_VALUE;

        if(len>1){
        for(int a=1; a<len; a++){
         int pointer = 0;
            int currentStringLen= strs[a].length();
            if(currentStringLen==0)return "";
            int range = Math.min(firstStringLen, currentStringLen);
            for(int b=0; b<range; b++){
                if(strs[a].charAt(b)==firstString[b]){
                    pointer++;
                }
                else break;
            }
            ans = Math.min(ans, pointer);
        }
        }
        if(ans == Integer.MAX_VALUE)return strs[0];
        return strs[0].substring(0,ans);
    }
}