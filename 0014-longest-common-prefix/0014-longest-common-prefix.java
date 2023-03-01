class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==0)return "";
        
        Arrays.sort(strs);
        int pointer = 0;
        
        while(pointer < strs[0].length()){
            if(strs[0].charAt(pointer) == strs[len-1].charAt(pointer))pointer++;
            else break;
        }
        return strs[0].substring(0, pointer);
        
    }
}