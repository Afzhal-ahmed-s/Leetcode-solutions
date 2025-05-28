package com.dsa.sheet.striver.stepthree.arrays;

import java.util.*;

public class LectureThree {

    // 1
    // T.C, S.C ? -> O(N^2), O(1)
    // Brute force, calculates using previous rows values
    public List<List<Integer>> generatePascalTriangle(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(Arrays.asList(1));
        if (numRows == 1) return ans;

        ans.add(Arrays.asList(1, 1));
        if (numRows == 2) return ans;

        int sum = 0;
        List<Integer> previousRow = null;

        for (int i = 3; i <= numRows; i++) {
            previousRow = ans.get(i - 2);
            List<Integer> local = new ArrayList<Integer>();

            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    local.add(1);
                } else {
                    sum = previousRow.get(j - 2) + previousRow.get(j - 1);
                    local.add(sum);
                }
            }
            ans.add(local);
        }

        return ans;
    }

    // T.C, S.C ? -> O(N^2), O(1)
    // Optimized, calculates using optimized maths
    public static List<List<Integer>> generatePascalTriangleOptimized(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        ans.add(Arrays.asList(1));
        if (numRows == 1) return ans;

        ans.add(Arrays.asList(1, 1));
        if (numRows == 2) return ans;

        int num = 1;

        for (int i = 2; i < numRows; i++) {
            List<Integer> local = new ArrayList<Integer>();

            local.add(1);

            for (int j = 1; j < i; j++) {
                num = num * (i - j + 1);
                num = num / j;
                local.add(num);
            }

            num = 1;
            local.add(1);
            ans.add(local);

        }

        return ans;

    }

    // 2
    // T.C, S.C: O(N), O(1)
    // Brute solution- Check for each element using nested for loop
    // Better solution- Using hashmap
    // Optimized solution using extended version of Moore's voting algorithm
    public List<Integer> majorityElement(int[] nums) {

        int length = nums.length;

        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        int countElement1 = 0;
        int countElement2 = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (countElement1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                countElement1++;
            } else if (countElement2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                countElement2++;
            } else if (element1 == nums[i]) countElement1++;
            else if (element2 == nums[i]) countElement2++;
            else {
                countElement1--;
                countElement2--;
            }
        }

        countElement1 = countElement2 = 0;

        for (int e : nums) {
            if (e == element1) countElement1++;
            else if (e == element2) countElement2++;
        }

        if (countElement1 > Math.floor(length / 3)) ans.add(element1);
        if (countElement2 > Math.floor(length / 3)) ans.add(element2);

        return ans;

    }


    // 3 Sum LeetCode is great algorithm that teaches us a lot

    // Better
    // Uses Set to eliminate duplicate triplets
    // Uses in-built sorting to push into set to eliminate duplicate triplets
    // Uses a hashset to find the third element
    // T.C, S.C ? -> O(N^2), O(N)
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> setToFindThirdElement = new HashSet<Integer>();
            List<Integer> triplet;

            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);

                if (setToFindThirdElement.contains(third)) {

                    // We are not clearing triplet list after adding in answer, as we are assigning one new each time to it.
                    triplet = Arrays.asList(nums[i], nums[j], third);
                    triplet.sort(null);
                    set.add(triplet);
                }

                setToFindThirdElement.add(nums[j]);
            }
        }

        return new ArrayList<>(set);

    }

    // Optimized
    // T.C, S.C ? ->  O(N^2), O(1)
    // The way we skip duplicates and put things in order troubled me severely the first time
    public List<List<Integer>> threeSumOptimal(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int sum;

        for (int i = 0; i < n; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum > 0) k--;
                else if (sum < 0) j++;
                else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }

        }
        return ans;

    }

    // 4
    // Optimized
    // T.C, S.C ? -> O(N^3), O(1)
    // The way we handled second pointer 'j' was new and different, troubled me a lot
    // 'long' data type used to handle large numbers here
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int l;
        int r;
        long sum;

        for (int i = 0; i < n; i++) {

            while (i > 0 && i < n && nums[i] == nums[i - 1]) i++;

            for (int j = i + 1; j < n; j++) {

                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) {

                    j++;
                }

                l = j + 1;
                r = n - 1;

                while (l < r) {

                    sum = (long) nums[i] + (long) nums[j] + (long) nums[l] + (long) nums[r];
                    if (sum > target) r--;
                    else if (sum < target) l++;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    }
                }

            }

        }

        return ans;

    }

    // 5
    // Optimal approach
    // Using prefix sum
    // T.C, S.C: O(N), O(N)
    public static int maxLen(int arr[]) {

        int sum = 0;
        int maxSubArrayLength = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxSubArrayLength = Math.max(maxSubArrayLength, i + 1);
            } else {
                if (map.get(sum) != null) {
                    maxSubArrayLength = Math.max(maxSubArrayLength, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }

        return maxSubArrayLength;

    }

    // 6
    // Optimal approach
    // Prefix xor
    // Troubled me even after solving multiple prefix problems
    // I need to revise
    // I need to learn the pattern of prefixSum problems
    public long subarrayXor(int arr[], int k) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        int prefixXor = 0;
        int n = arr.length;

        for(int i=0; i<n; i++){
            prefixXor = prefixXor ^ arr[i];

            int x = prefixXor ^ k;

            count += map.getOrDefault(x, 0);

            map.put( prefixXor, (map.getOrDefault(prefixXor, 0) + 1) );
        }

        return (long)count;
    }

    // 7
    // BruteFore
    // Brute force itself was extremely challenging
    // Lots of learnings must code problem each time
    // Very important
    // Sorting 2D array in a custom logic a) Using anonymous comparator class b) Using Java8+ Lambda
    // Convert List<List<Integer>> to int[][] a) If array length is unform b) Case a by using Stream API c) When array length is non-uniform
    // Convert List<int[]> to int[][]
    // T.C, S.C: O(2N), O(N) or (1) depending upon the return type
    public int[][] mergeBruteForce(int[][] intervals) {

            int n = intervals.length;

            // Sort the array w.r.t start value

            Arrays.sort(intervals, new Comparator<int[]>(){
                public int compare(int[] a, int[] b){
                    return a[0] - b[0];

                    // if a > b return +ve places b then a
                    // if b > a return -ve places a then b
                    // if a == b returns zero, they are equal in order
                }
            });

            // Sorting using Java8+ Lambda
            //Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

            List<int[]>ans = new ArrayList<int[]>();

            int istart;
            int iend;

            for(int i=0; i<n; i++){

                istart = intervals[i][0];
                iend = intervals[i][1];

                // Check overlapped intervals
                // If the current end range is within latest answer list's end range
                if( !ans.isEmpty() && ans.get( ans.size()-1 )[1] >= iend  ){
                    continue;
                }

                // Check end value for jend and iend
                for(int j=i+1; j<n; j++){
                    int jstart = intervals[j][0];

                    if(iend >= jstart){
                        int jend = intervals[j][1];
                        iend = Math.max(iend, jend);
                    }
                    else{
                        break;
                    }

                }
                ans.add( new int[]{istart, iend} );

            }

        // Convert List<List<Integer>> to int[][] a) If array length is unform b) Case a by using Stream API
        /*
        List<List<Integer>> list = new ArrayList<>();

            int[][] array = list.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
         */

        /*
        import java.util.*;

    // Convert List<List<Integer>> to int[][] c) When array length is non-uniform
    public class ListToJaggedArray {
        public static void main(String[] args) {
            List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4, 5),
                Arrays.asList(6)
            );

            int[][] array = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                List<Integer> row = list.get(i);
                array[i] = new int[row.size()];
                for (int j = 0; j < row.size(); j++) {
                    array[i][j] = row.get(j);
                }
            }

            for (int[] row : array) {
                System.out.println(Arrays.toString(row));
                }
            }
        }

         */

        // Convert List<int[]> to int[][]
            return ans.toArray( new int[ans.size()][] );

    }

    // 7
    // Optimal
    // Optimal is much simpler and easier than brute force (for the first time)
    public int[][] mergeOptimal(int[][] intervals) {

        int n = intervals.length;

        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[]b){
                return a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<int[]>();

        // int latestEndRangeIntervalFromAns = ans.get( ans.size()-1 )[1];

        for(int i=0; i<n; i++){

            if( ans.isEmpty() || ans.get( ans.size()-1 )[1] < intervals[i][0]){
                ans.add( new int[] {intervals[i][0], intervals[i][1]} );
            }
            else{
                ans.get( ans.size()-1 )[1] = Math.max(ans.get( ans.size()-1 )[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ ans.size() ][]);
    }

    // 8
    // Optimal
    // T.C, S.C ? -> O(m+n), O(1)
    public void mergeTwoSortedArraysOptimal(int[] nums1, int m, int[] nums2, int n) {

        // We come from behind because
        // a) We know arrays are sorted
        // b) Zeros are behind
        // c) At the end all elements are placed in the right positions


        int t1 = m-1; int t2 = n-1; int finalTail= m+n-1;

        while(t1>=0 && t2>=0){

            if(nums1[t1] >= nums2[t2]){
                nums1[finalTail] = nums1[t1];
                t1--;
            }
            else{
                nums1[finalTail] = nums2[t2];
                t2--;
            }
            finalTail--;

        }

        // Because nums2 is foreign and nums1 is native
        // If anything is left it's nums2 array only
        while(t2 >=0){
            nums1[finalTail] = nums2[t2];
            finalTail--;
            t2--;
        }

    }

    // 9
    // Optimal
    // T.C, S.C: O(N), O(1)
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        long n = (long)(row * col);

        long x_y; long S=0;
        long x2_y2; long S2=0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                S += grid[i][j];
                S2 += (long) (grid[i][j] * grid[i][j]);
            }
        }

        long Sn = (long)( (n*(n+1)/2) );
        long Sn2 = (long)( (n*(n+1)) * ((2*n)+1) )/6;

        x_y = S - Sn;
        x2_y2 = S2 - Sn2;

        long x = (long) ((x_y) + ( (x2_y2)/(x_y) ))/2;
        long y = x - (x_y);

        return new int[]{(int)x, (int)y};


    }

    // 10
    // Optimal
    // T.C, S.C: O(NlogN), O(N)
    static int inversionCount(int arr[]) {
        // Your Code Here
        return mergeSort(arr, 0, arr.length-1);
    }

    static int mergeSort(int[] arr, int l, int r){

        int count =0;

        // base condition
        if( l >= r )return count;

        int mid = (l+r)/2;

        count += mergeSort(arr, l, mid);
        count += mergeSort(arr, mid+1, r);
        count += merge(arr, l, mid, r);

        return count;

    }

    static int merge(int[] arr, int l, int mid, int r){
        int left = l;
        int right = mid+1;
        List<Integer> temp = new ArrayList<Integer>();

        int count=0;

        while(left <= mid && right <= r){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                count += mid-left+1;
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= r){
            temp.add(arr[right]);
            right++;
        }

        for(int i=l; i<=r; i++){
            arr[i] = temp.get(i-l);
        }

        return count;
    }

    // 11
    // Optimal solution
    // T.C, S.C: O(NlogN), O(N)
    // Integer overflow problem using explicit 'L' to modify default calculation
    public int reversePairs(int[] nums) {

        return reversePairsMergeSort(nums, 0, nums.length-1);

    }

    public int reversePairsMergeSort(int[] arr, int l, int r){
        int count = 0;

        // base condition
        if(l >= r)return count;

        int mid= (l+r)/2;
        count += mergeSort(arr, l, mid);
        count += mergeSort(arr, mid+1, r);
        count += helperReversePair(arr, l, mid, r);
        reversePairsMerge(arr, l, mid, r);

        return count;
    }

    public void reversePairsMerge(int[] arr, int l, int mid, int r){
        int left = l;
        int right = mid+1;
        List<Integer> temp = new ArrayList<Integer>();

        while(left <= mid && right <= r){
            if(arr[left] <= arr[right]){
                temp.add(arr[left++]);
            }
            else{
                temp.add(arr[right++]);
            }
        }

        while(left <= mid){
            temp.add(arr[left++]);
        }

        while(right <= r){
            temp.add(arr[right++]);
        }

        for(int i=l; i<=r; i++){
            arr[i] = temp.get(i-l);
        }

    }

    public int helperReversePair(int[] arr, int l, int mid, int r){
        int right = mid+1;
        int count = 0;

        for(int i=l; i<=mid; i++){
            while(right <= r && (long)(arr[i]) > (long)(2L*arr[right])){
                right++;
            }
            count += ( right - (mid+1) );
        }

        return count;
    }

    // 12
    // T.C, S.C: -> O(N), O(1)
    // Troubled me for days
    // Why suffix T.C: [-2,-9,-8] without suffix we cannot solve such cases
    // How we set prefix and suffix is also a good algorithm sequence
    public int maxProduct(int[] nums) {

        int n = nums.length;

        long prefix = 1; long suffix = 1;
        long maxProduct = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){

            // Step 1
            if(prefix == 0)prefix = 1;
            if(suffix == 0)suffix = 1;

            // Step 2
            prefix = prefix * (long)nums[i];
            suffix = suffix * (long)nums[n-i-1];

            // Step 3
            maxProduct = Math.max( maxProduct, Math.max(prefix, suffix) );
        }

        return (int)maxProduct;

    }





    public static void main(String[] args){

    }

}
