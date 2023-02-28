class Solution {
    public int romanToInt(String s) {
        int ans=0, prev=0, number=0;
        int len=s.length();
        
        for(int a=len-1; a>=0; a--){
            switch(s.charAt(a)){
                case 'I' : number = 1;
                           break;
                case 'V' : number = 5;
                           break;   
                case 'X' : number = 10;
                           break;
                case 'L' : number = 50;
                           break;
                case 'C' : number = 100;
                           break;
                case 'D' : number = 500;
                           break;
                case 'M' : number = 1000;
                           break;
            }
            if(number < prev)ans -= number;
            else ans += number;
            prev = number;    
        }
        return ans;
    }
}