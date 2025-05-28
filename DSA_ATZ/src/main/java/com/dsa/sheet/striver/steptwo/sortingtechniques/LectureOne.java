/// Notes:
// One-line summaries for each algorithm:
// Bubble Sort: Repeatedly swap adjacent elements
// if they are in the wrong order.
// Selection Sort: Select the smallest (or largest) element
// from the unsorted portion and move it to the beginning (or end).
// Insertion Sort: Insert each element into its proper
// position within the previously sorted portion.

// Stability of algorithms-
// Bubble sort: Stable
// Selection sort: Un-stable
// Insertion sort: Stable

// Best case scenario's T.C-
// BS- O(N)
// SS- O(N^2)
// IS- O(N)

// Selection sort vs Insertion sort-
// In selection sort, we have *proper sorted
// element* after every iteration including the index
// (i.e from beginning)
// In insertion sort, we have *localized sorted
// sub-array* including that index


package com.dsa.sheet.striver.steptwo.sortingtechniques;

import java.util.Arrays;

public class LectureOne {

    static void printArray(int[] arr){
        Arrays.stream(arr).forEach(e -> System.out.print(e+", "));
    }

    // T.C, S.C ? -> O(N^2), O(1)
    static void selectionSort(int[] arr) {

        int length = arr.length;

        for(int i=0; i<length-1; i++){

            int indexOfMinimumElement = i;

            for(int j=i+1; j<length; j++){
                if(arr[j] < arr[indexOfMinimumElement]){
                    indexOfMinimumElement = j;
                }
            }

            swap(i, indexOfMinimumElement, arr);

        }

    }

    static void swap(int a, int b, int[] arr){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    // T.C, S.C ? -> O(N^2), O(1)
    static void bubbleSortOptimal(int arr[]) {
        // code here

        for(int i=0; i<arr.length-1; i++){

            boolean swapped = false;

            for(int j=0; j<arr.length - 1 - i; j++){
                if(arr[j+1] < arr[j]){
                    swapped = true;
                    swap(j, j+1, arr);
                }
            }
            if(!swapped){ break; }
        }

    }

    // T.C, S.C ? -> O(N^2), O(1)
    static void insertionSort(int arr[]) {

        // Outer loop
        for(int i=0; i<arr.length; i++){

            int j=i;

            while(j>0 && arr[j] < arr[j-1]){

                swap(j-1, j, arr);
                --j;
            }

        }
    }


    public static void main(String[] args){
        int[] arr = new int[]{3,2,1,4,5};
        int[] arr2 = new int[]{1,2,3,4,5};

        insertionSort(arr2);
        printArray(arr2);
    }

}
