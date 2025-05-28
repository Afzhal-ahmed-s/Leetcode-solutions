package com.dsa.sheet.striver.steptwo.sortingtechniques;

/// Notes
// Merge sort is stable, quick sort is unstable
// Adaptability: Quick Sort is adaptive,
// meaning it can take advantage of existing order in the array.
// Merge Sort is not adaptive.
// Merge sort is best when working with larger data sets
// Quick sort is best when working with smaller data sets

// Average case:
// Merge sort: T.C: O(NlogN) and S.C: O(N) (auxiliary space)
// Quick sort: T.C: O(NlogN) and S.C: O(logN) - (recursive call stack depth)

// Worst case:
// Merge sort: T.C: O(NlogN) and S.C: O(N) (auxiliary space)
// Quick sort: T.C: O(N^2) and S.C: O(N) - (recursive call stack depth)

/// Learnings
// Quicksort troubled me in-
// a) We skip partitionPivot in the recursive calls
// b) In the partitionPivot function in the nested while
// conditions we have it as i(local) < right(global) and
// j(local) > left(global) and why not local limiting local instead we use
// global limiting local
// c) Why swap outside of while loop?
// d) Why return 'j' index instead of pivotIndex



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectureTwo {

    public static void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // T.C , S.C -> O(N^2), O(1) [Best case T.C: O(N)]
    public static void recursiveBubbleSortOptimized(int arr[]) {


        for(int i=0; i<arr.length-1; i++){
            boolean haveWeSwapped = false;

            boolean ans = helperRecursiveSort
                    (0, 1, arr.length -i, arr, haveWeSwapped);

            if(!ans){ break; }
        }

    }

    public static boolean helperRecursiveSort
            (int a, int b, int limit, int[] arr, boolean haveWeSwapped ){
        // Base condition
        if(b >= limit ){ return haveWeSwapped; }

        // Operation
        if(arr[a] > arr[b]){
            swap(a, b, arr);
            haveWeSwapped = true;
        }

        // Recursive call
        return helperRecursiveSort(++a, ++b, limit, arr, haveWeSwapped);
    }

    public static void recursiveInsertionSortOptimized(int arr[]) {

        for(int i=0; i<arr.length; i++){
            helperInsertionSort(i, arr);
        }

    }

    public static void helperInsertionSort(int a, int[] arr){

        // Base condition
        if( a-1 < 0){ return; }
        if( arr[a-1] < arr[a] ){ return; }

        // Operation
        if(arr[a-1] > arr[a]){ swap(a-1, a, arr); }

        // Recursive call
        helperInsertionSort(--a, arr);

    }

    void mergeSort(int arr[], int l, int r) {

        // Base condition
        if( l >= r){ return; }

        // Operation
        int mid = (l+r)/2;

        // Recursion call
        mergeSort(arr, l, mid);

        mergeSort(arr, mid+1, r);

        merge(arr, l, mid, r);

    }

    void merge(int arr[], int l, int mid, int r){

        int left = l;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<Integer>();

        while(left <= mid && right <= r){
            if(arr[left] <= arr[right]){ temp.add(arr[left++]); }
            else { temp.add(arr[right++]); }
        }

        while(left <= mid){
            temp.add(arr[left++]);
        }

        while(right <= r){
            temp.add(arr[right++]);
        }

        for(int i=l; i<= r; i++){
            arr[i] = temp.get(i - l); //0,1,2 (nice logic)
        }

    }

    static void quickSort(int arr[], int low, int high) {

        if(low < high){

            int partitionIndex = partitionPivotAsLow(arr, low, high);

            quickSort(arr, low, partitionIndex-1);

            quickSort(arr, partitionIndex + 1, high);

        }

    }

    // Considering Pivot = high
    static int partitionPivotAsHigh(int arr[], int low, int high) {
        // your code here

        int i= low;
        int j= high;
        int pivot = high;

        while(i < j){
            while(arr[i] < arr[pivot] && i < high){
                i++;
            }

            while(arr[j] >= arr[pivot] && j > low){
                j--;
            }

            if(i < j){ swap(i, j, arr); }
        }

        swap(i, pivot, arr);

        return i;

    }

    // Considering Pivot = low
    static int partitionPivotAsLow(int arr[], int low, int high) {
        // your code here

        int i = low;
        int j = high;
        int pivotIndex = low;

        while(i < j){

            while(arr[i] <= arr[pivotIndex] && i < high){
                i++;
            }

            while(arr[j] > arr[pivotIndex] && j > low){
                j--;
            }

            if(i < j){ swap(i, j, arr); }

        }

        swap(j, pivotIndex, arr);

        return j;
    }



    public static void main(String args[]) {

        int[] arr = new int[]{4, 1, 3, 9, 7};

        /*
        recursiveInsertionSortOptimized(arr);
        for(int e: arr){ System.out.print(e + ", "); }
         */


        System.out.println("Array before QuickSort: ");
        for (int e : arr){ System.out.print(e + ", "); }
        System.out.println("\n");

        quickSort(arr, 0, arr.length-1);

        System.out.println("Array after QuickSort: ");
        for (int e : arr){ System.out.print(e + ", "); }

    }}
