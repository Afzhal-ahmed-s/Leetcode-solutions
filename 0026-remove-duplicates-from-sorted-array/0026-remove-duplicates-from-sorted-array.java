class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int outside=0;
        
        //placing all unique elements to the left in order not worrying about duplicating
        for(int inside=0; inside<len; inside++){
            if(nums[inside] != nums[outside]){
                //System.out.println(outside+" "+inside);
                nums[++outside] = nums[inside];
            }
        }

        //number of unique elements = outside + 1 as outside is based on 0 based indexing
        return ++outside;
    }
}