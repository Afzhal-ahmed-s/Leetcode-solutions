import java.util.*;
import java.util.ArrayList;

public class MergeSort {

    public void printArray(int[] arr){
        int length = arr.length;

        System.out.print("[ ");
        for(int i=0; i<length-1; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.print( arr[length-1] + " ]");

        System.out.println();
    }
    
    public void merge(int[] arr, int low, int mid, int high) {

        List<Integer> list = new ArrayList<Integer>(); 

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                list.add(arr[left]);
                left++;
            }
            else{
                 list.add(arr[right]);
                 right++;
            }
        }

        while(left <= mid){
            list.add(arr[left]);
            left++;
        }

        while(right <= high){
            list.add(arr[right]);
            right++;
        }

        for(int i=low; i<=high; i++){
            arr[i] = list.get(i - low);
        }

    }

    public void mergeSort(int[] arr, int low, int high){
        if(low >= high)return;

        int mid = (high + low)/2;

        //left side
        mergeSort(arr, low, mid);

        //right side
        mergeSort(arr, mid+1, high);

        //merging the sorted arrays together
        merge(arr, low, mid, high);
    }


    public static void main(String[] args){
        MergeSort ms = new MergeSort();
        int[] arr = new int[]{1,5,7,4,2,3,6};
        int[] arr2 = new int[]{1,5,3,4,2,-1,30,45,-20,100};

        System.out.println("Array before sorting: ");
        ms.printArray(arr);
        ms.mergeSort(arr, 0, arr.length-1);
        System.out.println("Array after merge sorting: ");
        ms.printArray(arr);

        System.out.println();
    }

}
