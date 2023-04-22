class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int length = nums.length;
        int numberToPlaceAtIndex = 0;
        
        while( nonZeroIndex < length ){
            
            while(nonZeroIndex < length && nums[nonZeroIndex] == 0 )nonZeroIndex++;
            
            if(nonZeroIndex < length){
            //System.out.println(nonZeroIndex+" "+numberToPlaceAtIndex);    
            
            if(nonZeroIndex != numberToPlaceAtIndex)
            {
                nums[numberToPlaceAtIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
            }
                
            nonZeroIndex++;
            numberToPlaceAtIndex++;
                
            }    
        }
    }
}