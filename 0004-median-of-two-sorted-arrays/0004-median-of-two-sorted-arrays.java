class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] A = nums1;
        int[] B = nums2;
        int m = A.length;
        int n = B.length;
        
        if(A.length > B.length)return findMedianSortedArrays(B, A);
        
        int total = m+n;
        int half = (total + 1)/2;
        int l = 0;
        int r = m;
        
        double res = 0.0;
        
        while(l <= r){
            int i = l + (r - l)/2;
            int j = half - i;
            
            int Aleft = (i > 0) ? nums1[i-1] : Integer.MIN_VALUE;
            int Aright = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int Bleft = (j > 0) ? nums2[j-1] : Integer.MIN_VALUE;
            int Bright = (j < n) ? nums2[j] : Integer.MAX_VALUE;
            
            if(Aleft <= Bright && Bleft <= Aright){
                if(total%2 == 0){
                    res = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
                else res = Math.max(Aleft, Bleft);
                break;
            }
            else if(Aleft > Bright)r = i - 1;
            else l = i + 1;
        }
        return res;
    }
}
