package com.dsa.sheet.striver.stepfour.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureOne {

    // 1
    // Simple Binary search
    static public int search(int[] nums, int target) {

        int n = nums.length;
        int mid;
        int l = 0;
        int r = n-1;

        while(l <= r){
            mid = (l+r)/2;

            if(nums[mid] == target)return mid;
            else if(nums[mid] > target){
                r = mid-1;
            }
            else{
                l = mid+1;
            }

        }
        return -1;

    }

    // 2
    // Brute force: Traverse in a for loop if(arr[i] >= x)return i; as condition
    // Brute force T.C: O(N), S.C: O(1)
    // Optimal using binary search
    // Optimal T.C: O(N), S.C: O(1)
    static public int lowerBound(int[] nums, int x) {

        int n = nums.length;
        int ans = n;
        int mid;
        int l=0;
        int r = n-1;

        while(l<=r){
            mid = (l+r)/2;

            if(nums[mid] >= x){
                ans = mid;
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }
        return ans;

    }

    // 3
    // Brute force: Traverse in a for loop if(arr[i] > x)return i; as condition
    // Brute force T.C: O(N), S.C: O(1)
    // Optimal using binary search
    // Optimal T.C: O(N), S.C: O(1)
    static public int upperBound(int[] nums, int x){
        int n = nums.length;
        int mid;
        int l=0; int r=n-1;
        int ans=n;

        while(l<=r){
            mid = (l+r)/2;

            if(nums[mid] > x){
                ans = mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;

    }

    // 4
    // I did this by myself without referring to striver's sheet or any
    // I dry run a rough logic and built upon it
    // Strivers solution is bit different
    // I have three sub-components inside while loop
    // Whereas he has only two
    static public int searchInsert(int[] nums, int target) {
        int n= nums.length;
        int l=0, r=n-1;
        int mid;

        while(l<=r){
            mid = (l+r)/2;

            if(nums[mid] == target)return mid;
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return l;
    }

    // 5
    // T.C, S.C: O(logN), O(1)
    static public int[] getFloorAndCeil(int[] nums, int x) {
        int fl = getFloor(nums, x);
        int ce = getCeil(nums, x);

        return new int[]{fl, ce};
    }

    static public int getFloor(int[] arr, int x){
        int n = arr.length;
        int l=0, r=n-1, mid;
        int ans= -1;

        while(l <= r){
            mid = (l+r)/2;

            if(arr[mid] == x)return arr[mid];
            else if(arr[mid] < x){
                ans = arr[mid];
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }

    static public int getCeil(int[] arr, int x){
        int n = arr.length;
        int l=0, r=n-1, mid;
        int ans= -1;

        while(l <= r){
            mid = (l+r)/2;

            if(arr[mid] == x)return arr[mid];
            else if(arr[mid] < x){
                l = mid+1;
            }
            else{
                ans = arr[mid];
                r = mid-1;
            }
        }
        return ans;
    }

    // 6
    // T.C, S.C: O(logN), O(1)
    static public int[] searchRange(int[] nums, int target) {
        int fp= firstPosition(nums, target);
        int lp= lastPosition(nums, target);

        return new int[]{fp, lp};
    }

    static public int firstPosition(int[] arr, int target){
        int n= arr.length, l=0, r=n-1, mid, ans =-1;

        while(l <= r){
            mid = (l+r)/2;

            if(arr[mid] == target){
                ans = mid;
                r = mid-1;
            }
            else if(arr[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
    }

    static  public int lastPosition(int[] arr, int target){
        int n= arr.length, l=0, r=n-1, mid, ans =-1;

        while(l <= r){
            mid = (l+r)/2;

            if(arr[mid] == target){
                ans = mid;
                l = mid+1;
            }
            else if(arr[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
    }

    // 7
    // T.C, S.C: O(logN), O(1)
    static public int countOccurences(int[] nums, int target) {
        int fp= firstPosition(nums, target);
        int lp= lastPosition(nums, target);

        return (lp - fp + 1);
    }

    // 8
    // T.C, S.C: O(logN), O(1)
    static public int searchInSortedRotatedArraywithDistinctElements(int[] nums, int target)   {
        int n = nums.length;
        int l=0, r=n-1, mid;

        while(l <= r){

            mid = l + (r-l)/2;

            if(nums[mid] == target)return mid;

            // left portion is sorted
            // We can only apply binary search on sorted array
            // We only enter inside sorted array
            // We eliminate the other half this is the key to twisted binary search problem
            // STRIVER: ALWAYS IN A SORTED ROTATED ARRAY ONLY ONE HALF WILL BE SORTED, WE HAVE TO FIND A WAY TO ELIMINATE SEARCHING THE OTHER UNSORTED HALF IN THE CURRENT ITERATION AND SHRINK THE SEARCH RANGE AND FINALLY GET TO THE UNSORTED PORTION

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            // Right portion is sorted
            else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }

        }
        return -1;
    }

    // 9
    // T.C, S.C: O(logN), O(1)
    static public boolean searchInSortedRotatedArraywithDuplicateElements(int[] nums, int target) {

        int n = nums.length;
        int l=0, r=n-1, mid;

        while(l <= r){

            mid = l + (r-l)/2;

            if(nums[mid] == target)return true;

            // When we have duplicates in a sorted array this condition is critical
            // Because when l, mid, r are all the same using our regualr binary serach algorithm we cannot find which portion of the rray to pick and skip even if we do we most likely will end up picking the wrong one
            // So we have this step to manually reduce the search space to not enter into an infinite loop and determine which is the sorted array portion
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l = l+1;
                r = r-1;
                continue;
            }

            // left portion is sorted
            // We can only apply binary search on sorted array
            // We only enter inside sorted array
            // We eliminate the other half this is the key to twisted binary search problem
            // STRIVER: ALWAYS IN A SORTED ROTATED ARRAY ONLY ONE HALF WILL BE SORTED, WE HAVE TO FIND A WAY TO ELIMINATE SEARCHING THE OTHER UNSORTED HALF IN THE CURRENT ITERATION AND SHRINK THE SEARCH RANGE AND FINALLY GET TO THE UNSORTED PORTION

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }
            // Right portion is sorted
            else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }

        }
        return false;

    }

    // 10
    // T.C, S.C: O(logN), O(1)
    static public int findMin(int[] nums) {

        int n= nums.length;
        int l=0, r=n-1, mid;
        int ans= Integer.MAX_VALUE;

        while(l <= r){
            mid = r + (l-r)/2;

            // Additional optimization step
            if( nums[l] <= nums[r]){
                ans = Math.min(ans, nums[l]);
                break;
            }

            if(nums[l] <= nums[mid]){
                ans = Math.min(ans, nums[l]);
                l = mid+1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                r = mid-1;
            }
        }

        return ans;

    }

    // 11
    // T.C, S.C: O(logN), O(1)
    static public int findKRotation(ArrayList<Integer> nums) {
        int n = nums.size();
        int l=0, r=n-1, mid;
        int minElementIndex= -1;

        while(l <= r){

            mid = l + (r-l)/2;

            if(nums.get(l) <= nums.get(r)){
                if(nums.get(l) < nums.get(minElementIndex) ){
                    minElementIndex = l;
                    break;
                }
            }

            if( nums.get(l) <= nums.get(mid) ){
                if(minElementIndex == -1 || nums.get(l) < nums.get(minElementIndex)){
                    minElementIndex = l;
                }
                l = mid+1;
            }
            else{
                if(minElementIndex == -1 || nums.get(mid) < nums.get(minElementIndex)){
                    minElementIndex = mid;
                }
                r = mid-1;
            }
        }

        int kRotation = minElementIndex;
        return kRotation;

    }

    // 12
    // T.C, S.C: O(logN), O(1)
    static public int singleNonDuplicate(int[] nums) {

        int n = nums.length;
        int l=1, r=n-2, mid;
        int singleElement;

        // Edge cases
        if(n == 1)return nums[0];
        if(nums[0] != nums[1])return nums[0];
        if(nums[n-1] != nums[n-2])return nums[n-1];

        while( l<=r ){
            mid = l + (r-l)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            else if(mid%2 == 0 && nums[mid] == nums[mid+1] ||
                    mid%2 == 1 && nums[mid] == nums[mid-1]){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return -1;
    }

    // 13
    // We find a single peak element if there are multiple, we skip the other peak elements
    // T.C, S.C: O(logN), O(1)
    static public int findPeakElement(int[] nums) {

        int n = nums.length;
        int l=1, r=n-2;
        int mid; // mid = peakIndex here

        // Edge cases
        if(n==1) return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[n-1] > nums[n-2])return n-1;

        while( l<=r ){
            mid = l + (r-l)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])return mid;

            // Left portion of the mountain- upward slope
            if(nums[mid] > nums[mid-1] && nums[mid] < nums[mid+1]){
                l = mid+1;
            }
            // Right portion of the mountain- downward slope
            else if(nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]){
                r = mid-1;
            }
            // Inverse peak (or) valley
            else{
                l = mid+1;
                // We can also have it as ( r=mid-1 )
                // It does not make any difference, we just want to skip any on section
                // If confused look at strivers blog and the video
            }

        }

        return -1;

    }



    public static void main(String[] args){

        int[] arr1 = {3, 5, 8, 15, 19};
        int[] arr2 = {1,2,2,3};
        int x1 = 9, x2=2;

        int[] arr3 = {3, 4, 4, 7, 8, 10};
        int[] arr4 = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;

        int[] arr5 = {1,2,3,3,3,4,5,5,5,5,5,5,5,5};
        int x5 = 5;

        List<Integer> s4l1p11tc1 = Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3); // Desired o/p = 4
        List<Integer> s4l1p11tc2 = Arrays.asList(3, 4, 5, 1, 2); // Desired o/p = 3

        System.out.println("Find K rotation: " + findKRotation( new ArrayList<Integer>(s4l1p11tc1) ) );


//        System.out.println( countOccurences(arr5, x5) );
//        int[] fcAns = getFloorAndCeil(arr1, 1);
//        System.out.println("Floor: "+fcAns[0]+", Ceil: "+fcAns[1]);
//        int ind = upperBound(arr1, x1);
//        System.out.println("The upper bound is the index: " + ind);


    }

}
