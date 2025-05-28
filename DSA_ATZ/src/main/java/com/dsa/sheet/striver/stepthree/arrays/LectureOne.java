package com.dsa.sheet.striver.stepthree.arrays;

import java.util.*;

//// Learning:
/// I am repeatedly failing AT TWO POINTERS, Revise
// Single traversal find second largest element
// Convert a 'char' to 'int' ? -> Two ways
// -> i) Character.getNumericValue(); ii) '1' - '0';
// Convert 'String' to 'char'
// Replace all alphabets in string to ""

// Check if the array is sorted in a rotated manner formula?
// note: array could also not be sorted
// -> 'if(arr[i] < arr[(i+1) % arr.length])'
// Through this logic we can check if the array is sorted
// and un-sorted aswell
// Two mangoes one stone

// First two pointer problem
// Rotate the elements by k position procedure ?
// -> Rotate 0 to n-k, rotate n-k to n, rotate 0 to n

// Better than brute force logic to find out
// the missing number in an array from 0 to n
// Optimized formula to find out the missing number
// in an array from 0 to n ? -> Arithmetic Progression
// : ( n*(n+1) )/2 = n + (n-1) + (n-2) + (n-3)

// Two pointer using for loop

// XOR to find the missing element



public class LectureOne {
    // 1
    public static int largest(int[] arr) {
        // code here
        int max = -1;

        for(int e : arr){
            max = (e > max) ? e : max;
        }

        return max;
    }

    // 2
    // L.C version. [Single traversal] T.C, S.C ? -> O(N), O(1)
    public static int secondHighest(String s) {
        String onlyNumbers = s.replaceAll("[a-zA-Z]", "");

        int max = -1;
        int secondMax = -1;
        char[] charArr = onlyNumbers.toCharArray();

        for(char e : charArr){
            int num = Character.getNumericValue(e);
            // Or int num = e - '0';

            // If we find new maximum element update both maximum and second maximum
            if(num > max){
                secondMax = max;
                max = num;
            }

            // If we find a element smaller than secondMaximum and not equal to secondMaximum
            if(num != max && num > secondMax){
                secondMax = num;
            }
        }

        return secondMax;

    }

    // 3
    // T.C, S.C ? -> O(N), O(1)
    public static boolean check(int[] nums) {

        boolean alreadySorted = true;
        int irregularities = 0;

        // If array is already sorted
        for(int i=0 ;i<nums.length; i++){
            // if(nums[i] > nums[i+1]){
            //     irregularities++;
            // }

            if (nums[i] > nums[(i + 1) % nums.length]){
                irregularities += 1;
            }
        }
        return (irregularities > 1) ? false : true;
    }

    // 4
    // T.C, S.C ? -> O(N), O(1)
    // One pass
    public static int removeDuplicates(int[] nums) {

        int i=0;

        for(int j=1; j<nums.length; j++){

            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            // We get the distinctCount and array of
            // unique elements, which make this algorithm challenging
            // and a concept to must remember

        }
        return i+1;
        // We are returning i+1 because index is always
        // one number lesser than count
    }

    // 5
    // T.C, S.C ? -> O(N), O(1)
    public static void rotate(int[] nums, int k) {

        if(k < 0) { k = k + nums.length; }
        k = k%nums.length;

        reverse(nums, 0, nums.length - 1 - k);
        reverse(nums, nums.length - k, nums.length-1);
        reverse(nums, 0, nums.length-1);

        // an elegant algorithm
        // reverse the first half, then reverse the second half
        // reverse the entire array
    }

    public static void reverse(int[] nums, int l, int r){

        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }

    }

    // 6
    // T.C, S.C ? -> O(N), O(1)
    public static void moveZeroes(int[] nums) {

        int insertAtPosition= 0;
        int length= nums.length;

        for(int i=0; i<length; i++){
            if(nums[i] != 0){
                nums[insertAtPosition++] = nums[i];
            }
        }

        for(int i= insertAtPosition; i<length; i++){
            nums[i] = 0;
        }

    }

    // 7
    // T.C, S.C ? -> O(log(N)), O(1)
    static boolean searchInSorted(int arr[], int k) {

        int l= 0;
        int r= arr.length -1;
        int mid;

        while(l <= r){

            mid = (l + r)/2;

            if(k == arr[mid]){
                return true;
            }
            else if(k < arr[mid]){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }

        }

        return false;

    }

    // 8
    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        Set<Integer> set = new LinkedHashSet<Integer>();

        int i=0;
        int j=0;

        while(i < a.length && j < b.length){

            if(a[i] <= b[j]){
                set.add(a[i]);
                i++;
            }
            else if(a[i] > b[j]){
                set.add(b[j]);
                j++;
            }

        }

        while(i < a.length){
            set.add(a[i]);
            i++;
        }

        while( j< b.length){
            set.add(b[j]);
            j++;
        }

        return new ArrayList<Integer>(set);

    }

    // 9
    public static ArrayList<Integer> findUnionOptimized(int a[], int b[]) {

            ArrayList<Integer> list = new ArrayList<Integer>();

            int i=0;
            int j=0;

            while(i < a.length && j < b.length){

                if(a[i] <= b[j]){
                    if(list.size() == 0 || list.get(list.size() - 1) != a[i]){
                        list.add(a[i]);
                    }
                    i++;
                }
                else{
                    if(list.size() == 0 || list.get(list.size() - 1) != b[j]){
                        list.add(b[j]);
                    }
                    j++;
                }

            }

            while(i < a.length){
                if(list.size() == 0 || list.get(list.size() - 1) != a[i]){
                    list.add(a[i]);
                }
                i++;
            }

            while(j < b.length){
                if(list.size() == 0 || list.get(list.size() - 1) != b[j]){
                    list.add(b[j]);
                }
                j++;
            }

            return list;
        }

    // 10
    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = 0;

        sum = Math.round( ( n*(n+1) )/ 2);

        // for(int i=0; i<=n; i++){
        //     sum += i;
        // }

        for(int e: nums){
            sum -= e;
        }

        return sum;

    }

    // 11
    // I solved using two pointer but Striver had done using simple logic which is kind of intuitive not maths. LOL!
    public static int findMaxConsecutiveOnes(int[] nums) {

        int maxConsecutiveOnes = 0;
        int n = nums.length;
        int count;
        int j;

        for (int i = 0; i < n; i++) {

            j = i;
            count = 0;

            while (j < n && nums[j] == 1) {
                count++;
                j++;
            }
            if (count > maxConsecutiveOnes) {
                maxConsecutiveOnes = count;
            }

            i = j;

        }

        return maxConsecutiveOnes;

    }

    // 12
    public static int singleNumber(int[] nums) {

        int ans=0;

        for(int e: nums){
            ans = ans^e;
        }

        return ans;

    }

    // 13
    // Optimal when given array has negative, zeros and postives
    // Better approach when it has only zeros and postive number
    // T.C, S.C ? -> O(N) best case and worse and average case O(N^2)
    // when there is lot of hash collision where hash function is
    // poorly designed or when the load factor is too high.,
    // O(N) since we sre using a hashmap here
    public static int longestSubarray(int[] arr, int k) {

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        int n= arr.length;
        int maxLength= 0;
        long prefixSum = 0;
        long reminder= 0;

        for(int i=0; i<n; i++){

            prefixSum += arr[i];

            if(prefixSum == k){
                maxLength = Math.max( maxLength, i+1);
            }

            reminder = prefixSum -  k;

            if( map.containsKey(reminder) ){
                maxLength = Math.max( maxLength, i - map.get(reminder) );
            }

            if( !map.containsKey(prefixSum) ){
                map.put(prefixSum, i);
            }

        }

        return maxLength;
    }

    // 14
    // T.C, S.C ? -> O(N) all scenarios, O(1) all scenarios
    public static int longestSubarrayWhenNoNegativeNumbers(int[] arr, int k) {
        // code here

        int left = 0;
        int right = 0;
        int sum = 0;
        int n = arr.length;
        int maxLength = 0;

        while( right < n){

            sum += arr[right];

            if(sum == k){
                maxLength = Math.max(maxLength, right - left + 1);
            }

            while( left <= right && sum > k){
                sum -= arr[left];
                left++;
            }

            right++;

        }

        return maxLength;

    }



    public static void main(String[] args){

    }

}
