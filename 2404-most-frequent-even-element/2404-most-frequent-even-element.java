class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int freq = 0; int val = 1000000;
        
        for(int c: nums){
            if(c%2==0){
            int times = (hm.getOrDefault(c,0)+1);
            hm.put(c, times);
            if((freq < times || (freq==times && c<val))){
                val = c;
                freq = times;
            }
            }
        }
        
        return freq == 0 ? -1 : val;
        
    }
}