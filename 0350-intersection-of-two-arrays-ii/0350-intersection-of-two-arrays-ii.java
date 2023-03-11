class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int count=0;
        StringBuilder sb = new StringBuilder();
        List list = new ArrayList<>();
        
        for(int a=0; a<len1; a++){
            for(int b=0; b<len2; b++){
                if(nums1[a]==nums2[b]){
                    sb.append(nums2[b]+" ");
                    list.add(nums2[b]);
                    nums2[b] = -1;
                    count++;
                    break;
                }
            }
        }
        String s = new String(sb);
        //return s.trim().split(" ");
        int[] ans = new int[list.size()];
        for(int a=0; a<list.size(); a++){
            ans[a]= (int)list.get(a);
        }
        return ans;
    }
}