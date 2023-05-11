class Solution {
    public int majorityElement(int[] nums) {
        
        int len = nums.length;
        int count=0; int number=0;
        
        for(int e : nums){
            if(count == 0){
                number = e;
                count++;
            }
            else if(number != e){
                count--;
            }
            else{
                count++;     
            }
        }
        
        return number;
    }
}