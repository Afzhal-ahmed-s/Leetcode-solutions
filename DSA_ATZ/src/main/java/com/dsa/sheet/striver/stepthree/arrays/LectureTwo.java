package com.dsa.sheet.striver.stepthree.arrays;
import java.util.*;

/// Learnings
// One pass and two pass hashing

// Three pointers
// Dutch national flag algorithm -> Single pass three pointer [ Amazing one ]
// Moore's voting algorithm

// Kadane's algorithm
// Advanced Kadane's algorithm to find entire sub-array of largest sum      
// Kadane's algorithm self modified to give smallest minimum of sub array

// Buy and sell stock algorithm

// Next lexicographical permutation for an array or string

// Longest consecutive elements in non sorted array with linear time and space complexities.

// Set zeros, how will you handle first row and first colum edge case ? -> Via boolean flag and seperately dealing first row and column

// Transpose a matrix
// Rotate a matrix clockwise



public class LectureTwo {

    public static void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // 1
    // One pass hashing
    // Unsorted, return index
    // T.C, S.C ? -> O(N), O(N)
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] ans = {-1, -1};

        for (int i = 0; i < nums.length; i++) {

            if (map.size() == 0) {
                map.put(nums[i], i);
            } else if (map.containsKey(target - nums[i])) {
                ans = new int[]{i, map.get(target - nums[i])};
                break;
            } else {
                map.put(nums[i], i);
            }

        }
        return ans;
    }

    // 2
    // Two pass using counts
    // T.C, S.C ? -> O(N), O(1)
    public static void sortColorsBetter(int[] nums) {

        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int index = 0;
        int n = nums.length;

        for (int e : nums) {
            if (e == 0) {
                zeros++;
            } else if (e == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        while (zeros > 0 && index < n) {
            nums[index++] = 0;
            zeros--;
        }
        while (ones > 0 && index < n) {
            nums[index++] = 1;
            ones--;
        }
        while (twos > 0 && index < n) {
            nums[index++] = 2;
            twos--;
        }


    }

    // 2
    // Dutch national flag algorithm
    // T.C, S.C ? -> O(N), O(1)
    public static void sortColorsOptimal(int[] nums) {

        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(mid, low, nums);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(mid, high, nums);
                high--;
            } else {
                mid++;
            }
        }

    }

    // 3
    // T.C, S.C ? -> O(N), O(N)
    // Using hashing/ map
    public static int majorityElementBetter(int[] nums) {

        int maxCount = 0;
        int element = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int currentCount;

        for(int e: nums){

            map.put(e, map.getOrDefault(e, 0) + 1);
            currentCount = map.get(e);

            if(currentCount > maxCount ){
                maxCount = currentCount;
                element = e;
            }

        }

        return element;

    }

    // 3
    // T.C, S.C -> O(N), O(1)
    // Using Moore's voting algorithm
    public static int majorityElementOptimal(int[] nums) {

        int count = 0;
        int element = nums[0];

        for(int e : nums){
            if(e == element){
                count++;
                element = e;
            }
            else{
                count--;
                if(count == 0){
                    element = e;
                    count++;
                }
            }
        }

        return element;
    }

    // 4
    // Kadane's algorithm // Sequence matters a lot else will solve for edge cases like- ar = [-1]
    public static int maxSubArrayOptimal(int[] nums) {

        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i< nums.length; i++){

            // step 1
            sum += nums[i];

            // step 2
            maximumSum = Math.max(maximumSum, sum);

            // step 3
            if(sum < 0){
                sum = 0;
            }

        }

        return maximumSum;

    }

    // 5
    // Kadane's algorithm
    // Advanced variation
    public static void maxSubArrayPrintSubArray(int[] nums) {

        int maximumSum = Integer.MIN_VALUE;
        int sum = 0;

        // Addition
        int ansStartIndex = -1; int ansEndIndex = -1;
        int start = 0;

        for(int i=0; i< nums.length; i++){

            // Additional step
            // step 4
            if(sum == 0)start = i;

            // step 1
            sum += nums[i];

            // Additional sub step
            // step 2
            if(sum > maximumSum){
                maximumSum = sum;
                ansStartIndex = start;
                ansEndIndex = i;
            }

            // step 3
            if(sum < 0){
                sum = 0;
            }

        }

        System.out.println("The indexes > ansStartIndex: "+ ansStartIndex+ ", ansEndIndex: "+ ansEndIndex);
        System.out.println("The maximum sum subarray: ");
        for(int i= ansStartIndex; i<=ansEndIndex; i++){
            System.out.print(nums[i] + ", ");
        }

    }

    // 4
    // Kadane's algorithm modified (self)
    // Get smallest subarray sum
    public static int smallestMinSubArrayOptimal(int[] nums) {

        int minimumSum = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i< nums.length; i++){

            // step 1
            sum += nums[i];

            // step 2
            minimumSum = Math.min(minimumSum, sum);

            // step 3
            if(sum > 0){
                sum = 0;
            }

        }

        return minimumSum;

    }

    public static void minSubArrayPrintSubArray(int[] nums){

        int start = 0;
        int ansStart = 0; int ansEnd = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;

        for(int i=0; i<nums.length; i++){

            // Step 1
            if( sum == 0){
                start = i;
            }

            // Step 2
            sum = sum + nums[i];

            // Step 3
            if( sum < minSum){
                minSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            // Step 4
            if(sum > 0){
                sum = 0;
            }

        }

        System.out.println("The indexes > ansStartIndex: "+ ansStart+ ", ansEndIndex: "+ ansEnd);
        System.out.println("The minimum sum subarray: ");
        for(int i= ansStart; i<=ansEnd; i++){
            System.out.print(nums[i] + ", ");
        }

    }

    // 6
    // T.C, S.C ? -> O(N), O(1)
    public int maxProfit(int[] prices) {

        int n = prices.length;

        int minStockPriceUntilThisPoint = prices[0];
        int minStockPriceUntilThisPointIndex = 0;
        int maxProfit = 0;
        int maxProfitIndex = 0;

        for(int i=1; i<n; i++){

            // Step 1
            if(prices[i] < minStockPriceUntilThisPoint){
                minStockPriceUntilThisPoint = prices[i];
                minStockPriceUntilThisPointIndex = i;
            }

            // Step 2
            if(prices[i] - minStockPriceUntilThisPoint > maxProfit){
                maxProfit = prices[i] - minStockPriceUntilThisPoint;
                maxProfitIndex = i;
            }

        }

        return maxProfit;

    }

    // 7
    // T.C, S.C ? -> O(N), O(N).
    public static int[] rearrangeArray(int[] nums) {

        int n = nums.length;
        int positiveIndex = 0;
        int negativeIndex = 0;
        int index = 0;
        int[] arr = new int[nums.length];

        while(index < n && positiveIndex < n && negativeIndex < n){

            while(nums[positiveIndex] < 0){
                positiveIndex++;
            }
            arr[index] = nums[positiveIndex];
            index++;

            while(nums[negativeIndex] >= 0){
                negativeIndex++;
            }
            arr[index] = nums[negativeIndex];
            index++;

            positiveIndex++;
            negativeIndex++;

        }

        return arr;

    }

    // 8
    // T.C, S.C ? -> O(N), O(1)
    public static void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        int bigNumberIndex = -1;
        int n = nums.length;                                                                                                                                                                                                                                                                                                                                                                                                                                

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivotIndex = i;
                break;
            }
        }

        if(pivotIndex == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>=0; i--){

            if(nums[i] > nums[pivotIndex]){
                bigNumberIndex = i;
                swap(nums, bigNumberIndex, pivotIndex);
                break;
            }

        }

        reverse(nums, pivotIndex + 1, n-1);

        return;

    }

    public static void swap(int[] arr, int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int[] nums, int a, int b){
        while(a < b){
            swap(nums, a, b);
            a++;
            b--;
        }
    }

    // 9
    // T.C, S.C ? -> O(N), O(N)
    static ArrayList<Integer> leadersOptimal(int arr[]) {
        // code here

        int n = arr.length;
        int largestElementIndexPointer = n-1;

        ArrayList<Integer> ans = new ArrayList<Integer>();

        ans.add(arr[n-1]);

        for(int i= n-2; i>=0; i--){
            if(arr[i] >= arr[largestElementIndexPointer]){
                ans.add(0, arr[i]);
                largestElementIndexPointer = i;
            }
        }

        return ans;

    }

    // 10
    // SELF
    // Intution:
    // Using treeSet, ArrayList
    // T.C: O(N), S.C: O(2N)
    public static int longestConsecutiveSubOptimal(int[] nums) {

        int n= nums.length;
        if(n == 0)return 0;

        Set<Integer> treeSet = new TreeSet<Integer>();
        int count = 1;
        int maxCount = 1;

        for(int i=0; i<n; i++){
            treeSet.add(nums[i]);
        }

        List<Integer> list = new ArrayList<Integer>(treeSet);
        int listSize = list.size();

        for(int i=0; i< list.size() - 1; i++){

            while( i+1 < listSize && (list.get(i) + 1) == list.get(i+1)){
                count += 1;
                maxCount = Math.max(count, maxCount);
                i++;
            }
            count = 1;

        }

        return maxCount;
    }

    // 10
    // Optimized:
    // Using HashSet only and a logic
    // T.C: O(N), S.C: O(N)
    public static int longestConsecutiveOptimal(int[] nums) {

        int n= nums.length;
        if(n == 0)return 0;

        Set<Integer> hashSet = new HashSet<Integer>();
        int count = 1;
        int maxCount = 1;

        for(int i=0; i<n; i++){
            hashSet.add(nums[i]);
        }

        for(int e: hashSet){

            if(!hashSet.contains(e-1)){
                while(hashSet.contains(e+1)){
                    count++;
                    maxCount = Math.max(count, maxCount);
                    e = e+1;
                }
            }

            count =1;
        }

        return maxCount;
    }

    // 11
    // Optimized
    // T.C: O(N^2), S.C: O(1)
    // Using boolean for handling the edge case
    public static void setZeroesOptimal(int[][] matrix) {

        int nRows = matrix.length;
        int nCols = matrix[0].length;
        boolean isFirstRowElementZero = false;
        boolean isFirstColumnElementZero = false;

        // Traversing every element, finding the zeros and setting the 0th row,  0th column as zero
        // If first row has zero mark it via boolean flag
        // If first column has zero then mark via boolean flag
        for(int i=0; i<nRows; i++){
            for(int j=0; j<nCols; j++){

                if(matrix[i][j] == 0){
                    if(i == 0)isFirstRowElementZero = true;
                    if(j == 0)isFirstColumnElementZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        // Except first row, set the row's every element as '0'
        for(int i=1; i<nRows; i++){
            if(matrix[i][0] == 0)Arrays.fill(matrix[i], 0);
        }

        // Except first column, set the column's every element as '0'
        for(int j=1; j<nCols; j++){
            if(matrix[0][j] == 0){
                for(int i=0;i<nRows; i++){
                    matrix[i][j] = 0;
                }
            }
        }

        // Check if first row had any zero's via boolean flag.
        // If yes then mark the entire first row as zero.
        if(isFirstRowElementZero)Arrays.fill(matrix[0], 0);

        // Check if the first column has any zero's via boolean flag.
        // If yes them mark the entire first column as zero.
        if(isFirstColumnElementZero){
            for(int i=0; i<nRows; i++){
                matrix[i][0] = 0;
            }
        }

    }

    // 12
    public static void rotateMatrixClockwise(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Mirror mtrix wr.r.t x-axis
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                mirrorXaxisSwapMatrix(matrix, i, j);
            }
        }

        // Step 2: Transpose matrix
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                transposeSwapInMatrix(matrix, i, j);
            }
        }

    }

    public static void transposeSwapInMatrix(int[][]matrix, int row, int col){
        // System.out.println("Check: "+ matrix[row][col]+" <-> "+matrix[col][row]);
        int temp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = temp;
    }

    public static void mirrorXaxisSwapMatrix(int[][]matrix, int row, int col){
        int n = matrix.length;

        int temp = matrix[row][col];
        matrix[row][col] = matrix[n-1-row][col];
        matrix[n-1-row][col] = temp;
    }


    // 13
    // T.C, S.C: O(NxN), O(1)
    // What I missed- 1. Is for single row or single column
    //                2. Whether at every for loop all for parameter variables are being checked
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<Integer>();

        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = nRows - 1;
        int endCol = nCols - 1;


        while(startRow <= endRow && startCol <= endCol){

            // Top
            // Here startRow, endRow, startCol and endCol are all being checked
            for(int j=startCol; j<=endCol; j++){
                ans.add(matrix[startRow][j]);
            }
            startRow++;

            // Right
            // Here startRow, endRow, startCol and endCol are all being checked
            for(int i=startRow; i<=endRow; i++){
                ans.add(matrix[i][endCol]);
            }
            endCol--;

            // Bottom
            // Here startRow, endRow, startCol and endCol are all being checked
            if(startRow <= endRow){
                for(int j=endCol; j>=startCol; j--){
                    ans.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // Left
            // Here startRow, endRow, startCol and endCol are all being checked
            if(startCol <= endCol){
                for(int i=endRow; i>=startRow; i--){
                    ans.add(matrix[i][startCol]);
                }
                startCol++;
            }

        }

        return ans;

    }

    // 14
    // Better
    // T.C, S.C: O(N^2), S.C: O(1)
    public static int subarraySumBetter(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
            sum = 0;
        }

        return count;
    }

    // 14
    // Optimal
    // Prefix sum
    // T.C: O(N), S.C: O(N)
    public int subarraySumOptimal(int[] nums, int k) {

        int n = nums.length;

        Map<Integer, Integer> presumMap = new HashMap<Integer, Integer>();
        presumMap.put(0,1);

        int count = 0;
        int presum = 0;
        int difference = 0;

        for(int i=0; i<n; i++){
            presum += nums[i];

            difference = presum - k;

            count += presumMap.getOrDefault(difference, 0);

            presumMap.put( presum, presumMap.getOrDefault(presum, 0) + 1 );
        }

        return count;

    }






    public static void main(String[] args){

        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr2 = {-2};
        int[] arr3 =  {-2, -3, -1, -4, -5};
        int[] arr4 =  {2, 3, 1, 4, 5};
        int[] arr5 = {2, -3, 40, -2, -1, -150, 8};
        int[] arr6 = {5};


//        System.out.println( "Answer: "+ smallestMinSubArrayOptimal(arr5) );
//           maxSubArrayPrintSubArray(arr5);
           minSubArrayPrintSubArray(arr3);
//         System.out.println( "Answer: "+ smallestMinSubArrayOptimal(arr4) );

    }
}
