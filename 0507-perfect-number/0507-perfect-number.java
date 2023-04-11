class Solution {
    public boolean checkPerfectNumber(int num) {

        int ans=0;
        int limit = (int)Math.sqrt(num);
        
        for(int i=1; i<=limit && i!=num; i++){
            if(num % i == 0){
                ans+=i;
                if(num/i != i && num/i != num)ans+= (num/i);
        }
        }
        //System.out.println("Check: ans= "+ans+" , num= "+num);
        return (ans == num) ? true : false;
    }
}