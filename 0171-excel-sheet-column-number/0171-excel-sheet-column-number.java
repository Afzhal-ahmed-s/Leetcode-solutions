class Solution {
    public int titleToNumber(String columnTitle) {
        
        int len = columnTitle.length();
        if(len==0)return 0;
        if(len==1)return columnTitle.charAt(0)-64;
        
        int ans = columnTitle.charAt(0)-64;
                
        for(int a=1; a<len; a++){
            ans = ans*26 + (columnTitle.charAt(a)-64);
        }

        return ans;
    }
}