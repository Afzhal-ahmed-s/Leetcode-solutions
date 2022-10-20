class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int s = 0;
        int e = 0;
        int ans = Integer.MAX_VALUE;
        
        for(int i : piles){
            e = Math.max(i, e);
        }
                
        while(s <= e)
        {
            
            int mid = (s + e)/2;
            
            int k = 0; 
            for(int onePile : piles)
            {
                 k += (int)Math.ceil( 1.0 * onePile /mid );
            }

            if(k <= h){
                ans = Math.min(ans, mid);
                e = mid - 1;
            }
            else s = mid + 1;

        }
        return ans;
    
    }
}
