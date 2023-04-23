public class QuickSort {
    

    public void printArray(int[] arr){
        int length= arr.length;

        System.out.print("[ ");

        for(int i=0; i<length-1; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println(arr[length-1]+" ]");
    }

    public void swap(int[] arr, int left, int right){
        int temp=arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public int partitionAndPartialSort(int[] arr, int low, int high){
        
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){

            //arr[i] <= pivot  for ascending, for descending arr[i] >= pivot 
            while(arr[i] <= pivot && i <= high){
                i++;
            }
            //arr[j] > pivot  for ascending, for descending arr[j] < pivot 
            while(arr[j] > pivot && j >= low){
                j--;
            }
            if(i < j)swap(arr, i, j);
        }
        swap(arr, low, j);
        //printArray(arr);
        return j;
    }

    public void quickSortFunction(int[] arr, int low, int high){

        if(low >= high)return;
        else{

            int pivot = partitionAndPartialSort(arr, low, high);

            quickSortFunction(arr, low, pivot - 1);
            quickSortFunction(arr, pivot + 1, high);

        }
    }

    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{5,7,3,1,2,6,4,4,-1};

        System.out.println("Array before sorting:");
        qs.printArray(arr);
        qs.quickSortFunction(arr, 0, arr.length - 1);
        System.out.println("Array after quick sorting: ");
        qs.printArray(arr);
    }

}
