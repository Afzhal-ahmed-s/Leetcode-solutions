class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//my intutional solution        
//         int[] dupNums1 = new int[m];
        
//         for(int a=0; a<m; a++){
//             dupNums1[a] = nums1[a];
//         }
        
//         int c1 = 0; int c2 = 0;
//         int run = 0;
        
//         while(c1<m && c2<n){
//             if(dupNums1[c1] < nums2[c2]){
//                 nums1[run] = dupNums1[c1];
//                 c1++;
//             }
//             else {
//                 nums1[run] = nums2[c2];
//                 c2++;
//             }
//             run++;
//         }
//         //System.out.println(run+" "+c1+" "+m+" "+c2+" "+n);

//         while(c1 < m){
//             nums1[run] = dupNums1[c1];
//             run++; c1++;
//         }
        
//         while(c2 < n){
//             nums1[run] = nums2[c2];
//             run++; c2++;
//         }
//         //System.out.println(run+" "+c1+" "+m+" "+c2+" "+n);
        
           int t1 = m-1; int t2 = n-1; int finalTail= m+n-1;
        
            while(t1>=0 && t2>=0){
                nums1[finalTail--] = (nums1[t1] > nums2[t2]) ? nums1[t1--] : nums2[t2--];
            }
            
            while(t2 >=0){
                nums1[finalTail--] = nums2[t2--];
            }
}
}