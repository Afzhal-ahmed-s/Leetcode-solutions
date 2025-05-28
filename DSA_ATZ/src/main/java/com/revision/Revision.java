package com.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision {


   /*

    Revise To-Do-
    From LectureTwo-
        [DONE] striverQuestion17
        [DONE] kunalQuestion17_ap2
        [DONE] striverQuestion22

        Merge sort

        Quick sort

   */

    // Helper functions
    static void printArray(int[] arr){
        Arrays.stream(arr).forEach(e -> System.out.print(e+", "));
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Actual functions
   public static void striverQuestion17(int n){

    /*
    Question 17:

    Input Format: N = 6
    Result:
         A
        ABA
       ABCBA
      ABCDCBA
     ABCDEDCBA
    ABCDEFEDCBA
    */

       for(int i=0; i<n; i++) {

           // Left spaces
           for(int j = 0; j < n-i-1; j++) {
               System.out.print(" ");
           }


           // Left alphabets
           for(int j=0; j<i+1; j++){
               System.out.print( (char)('A' + j) );
           }

           // Right alphabets
           for(int j=0; j<i; j++){
               System.out.print( (char)('A' + i -1 -j) );
           }

           // Next line
           System.out.println();

       }

   }

   public static void kunalQuestion17_ap2(int n) {

       /*
            Question from Kunal Kushawa:

            N=4
                 1
                212
               32123
              4321234
               32123
                212
                 1
       */

       for(int i=0; i<n; i++){

           // Left spaces
           for(int j=0; j<n-i-1; j++){
               System.out.print(" ");
           }

           // Left top numbers
           for(int j=0; j<i+1; j++){
               System.out.print(i+1 -j);
           }

           // Right top numbers
           for(int j=0; j<i; j++){
               System.out.print(2+j);
           }

           // Next line
           System.out.println();

       }

       for(int i=n; i<2*n-1; i++){

           // Left spaces
           for(int j=0; j<i+1-n; j++){
               System.out.print(" ");
           }

           // Left bottom numbers
           for(int j=n-(i-n+1); j>0; j--){
               System.out.print(j);
           }

           // Right bottom numbers
           for(int j=0; j<n-(i-n+2); j++){
               System.out.print(2+j);
           }

           // Next line
           System.out.println();
       }

   }

   // T.C: O(N^2), S.C: O(N^2)
   public static void striverQuestion22BruteForce(int n) {

       /*
    Input Format: N = 3
    Result:
    3 3 3 3 3
    3 2 2 2 3
    3 2 1 2 3
    3 2 2 2 3
    3 3 3 3 3

    Input Format: N = 6
    Result:
    6 6 6 6 6 6 6 6 6 6 6
    6 5 5 5 5 5 5 5 5 5 6
    6 5 4 4 4 4 4 4 4 5 6
    6 5 4 3 3 3 3 3 4 5 6
    6 5 4 3 2 2 2 3 4 5 6
    6 5 4 3 2 1 2 3 4 5 6
    6 5 4 3 2 2 2 3 4 5 6
    6 5 4 3 3 3 3 3 4 5 6
    6 5 4 4 4 4 4 4 4 5 6
    6 5 5 5 5 5 5 5 5 5 6
    6 6 6 6 6 6 6 6 6 6 6
     */

       // Initializing movers
    int sr = 0; int er= (2*n)-2; int sc = 0; int ec = (2*n)-2;

    int[][] ans = new int[2*n-1][2*n-1];

    int number = n;

    while(sr <= er && sc <= ec){

        for(int j=sc; j<= ec; j++){
            ans[sr][j] = number;
        }
        sr++;

        for(int i=sr; i<= er; i++){
            ans[i][ec] = number;
        }
        ec--;

        for(int j= ec; j>=sc; j--){
            ans[er][j] = number;
        }
        er--;

        for(int i=er; i>=sr; i--){
            ans[i][sc] = number;
        }
        sc++;

        number--;
    }

    // Print the answer 2D array
    helperStriverQuestion22(ans);

    }

    // T.C: O(N^2), S.C: O(1)
    public static void striverQuestion22Optimized(int n){

       for(int row=0; row<2*n-1; row++){
            int distanceFromTop = row;
            int distanceFromBottom = (2*n)-2-row;

            for(int col=0; col<2*n-1; col++){
                int distanceFromLeft = col;
                int distancefromRight = (2*n)-2-col;

                System.out.print( n- Math.min( Math.min(distanceFromTop, distanceFromBottom), Math.min(distanceFromLeft, distancefromRight) ) + " ");
            }

            System.out.println();

       }

    }

    public static void helperStriverQuestion22(int[][] matrix){

       int n = matrix.length;

       for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               System.out.print(matrix[i][j]+" ");
           }
           System.out.println();
       }

    }

    static void mergeSort(int[] arr, int l, int r){

       // Base condition
       if( l >= r){ return; }

       // Operation

        int mid = (int) (l+r)/2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);

        merge(arr, l, mid, r);

        // When the first call is done. The array will be sorted
    }

    static void merge(int[] arr, int l, int mid, int r){

       List<Integer> temp = new ArrayList<Integer>();

       int left = l;
       int right = mid+1;

       while( left <= mid && right <= r ){
           if( arr[left] <= arr[right]){
               temp.add(arr[left++]);
           }
           else{
               temp.add(arr[right++]);
           }
       }
       while( left <= mid){
           temp.add(arr[left++]);
       }
       while( right <= r){
           temp.add(arr[right++]);
       }

       for(int i=l; i<=r; i++){
           arr[i] = temp.get(i-l);
       }

    }

    static void quickSort(int[] arr, int l, int r){

        if(l > r)return;

        int pivotIndex = partitionPivotasLow(arr, l, r);

        quickSort(arr, l, pivotIndex-1);
        quickSort(arr, pivotIndex+1, r);

    }

    static int partitionPivotasLow(int[] arr, int l, int r){

        int pivotIndex = l;
        int left = l;
        int right = r;

        while( left < right){

            while(arr[left] <= arr[pivotIndex] && left < r){
                left++;
            }
            while(arr[right] > arr[pivotIndex] && l < right){
                right--;
            }
            if(left < right)swap(arr, left, right);

        }

        swap(arr, pivotIndex, right);
        return right;

    }

    public static void main(String[] args){


        int n = 5;

        int[] arr = new int[]{4, 5, 2, 3 ,1};

        /*
        mergeSort(arr, 0, arr.length-1);

        System.out.println("The merge sorted array is: ");
        printArray(arr);
         */

        quickSort(arr, 0, arr.length-1);
        System.out.println("The quick sorted array is: ");
        printArray(arr);

    }

}
