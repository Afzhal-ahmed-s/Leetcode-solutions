class Solution {
    public int romanToInt(String s) {
        Map map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // map.put('IV', 4); map.put('IX', 9);
        // map.put('XL', 40); map.put('XC', 90);
        // map.put('CD', 400); map.put('CM', 900);
        
        int ans=0;
        int len= s.length();
        Boolean LastIndex = false;
        for(int a=0; a<len-1; a++){
            System.out.println("Check: "+a+" "+ans);

            if(s.charAt(a)=='I'){
                if(s.charAt(a+1)=='X')
                {ans+=9; a++; if(a==(len-1))LastIndex=true;}
                else if(s.charAt(a+1)=='V'){ans+=4; a++; if(a==(len-1))LastIndex=true;}
                else ans++;
            }
             else if(s.charAt(a)=='X'){
                if(s.charAt(a+1)=='L'){ans+=40; a++; if(a==(len-1))LastIndex=true;}
                else if(s.charAt(a+1)=='C'){ans+=90; a++;if(a==(len-1))LastIndex=true;}
                else ans+=10;
            }
             else if(s.charAt(a)=='C'){
                if(s.charAt(a+1)=='D'){ans+=400; a++; if(a==(len-1))LastIndex=true;}
                else if(s.charAt(a+1)=='M'){ans+=900; a++; if(a==(len-1))LastIndex=true;}
                else ans+=100;
            }
            else if(s.charAt(a)=='V')ans+=5;
            else if(s.charAt(a)=='L')ans+=50;
            else if(s.charAt(a)=='D')ans+=500;
            else if(s.charAt(a)=='M')ans+=1000;
        }

        if(!LastIndex)ans += (int)(map.get(s.charAt(len-1)));
        
        return ans;
    }
}