class SelectionSort{

    public SelectionSort(){

    }

    public void selectionSortFunction(int arr[]){
        int length = arr.length;

        for(int i=0; i<length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<length; j++){
                   if(arr[j] < arr[minIndex]){
                    minIndex = j;
                   } 
            }
            
            //Pass by reference
            swap(arr, minIndex, i);
        }

        for(int i=0; i<length; i++){
        System.out.print(arr[i]+" ");
        }

    }

    //Pass by reference
    public void swap(int[] arr, int left, int right){

        int temporary = arr[left];
        arr[left] = arr[right];
        arr[right] = temporary;

    }

    public static void main(String args[]){
        SelectionSort sS = new SelectionSort();
        int[] arr1 = new int[]{5, 2, 1, 3, 4};
        sS.selectionSortFunction(arr1);
    }
}