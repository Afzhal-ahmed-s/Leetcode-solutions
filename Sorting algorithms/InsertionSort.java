public class InsertionSort {
    
    public void insertionSortFunction(int[] arr){

        int length = arr.length;

        for(int i = 0; i < length; i++){
            int j=i;

            while(j > 0 && arr[j-1] > arr[j]){
                swap(arr, j-1, j);
                j--;
            }
        }

        for(int i = 0; i < length; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public void swap(int[] arr, int left, int right){
        int temporary = arr[left];
        arr[left] = arr[right];
        arr[right] = temporary;
    }

public static void main(String[] args){
    InsertionSort iS = new InsertionSort();
    int arr[] = new int[]{7, 3, 4, 1, 2, 6, 5};
    iS.insertionSortFunction(arr);
}

}
