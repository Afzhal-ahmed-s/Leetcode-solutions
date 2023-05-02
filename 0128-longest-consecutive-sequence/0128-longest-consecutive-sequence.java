class Solution {
    public int longestConsecutive(int[] nums) {
        
        int longestConsecutiveSequence = 0;
        Set set = new HashSet<Integer>();
        
        for(int e : nums)set.add(e);
        
        for(int e : nums){
            if(!set.contains(e-1)){
                int currentStreak = 1;
                int currentElement = e;
                
                while(set.contains(currentElement + 1)){
                    currentStreak += 1;
                    ++currentElement;
                }
                longestConsecutiveSequence = Math.max(longestConsecutiveSequence, currentStreak);

            }
        }
        
        return longestConsecutiveSequence;
    }
}