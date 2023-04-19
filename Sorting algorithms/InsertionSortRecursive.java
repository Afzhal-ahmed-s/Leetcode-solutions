class InsertionSortRecursive {

        public void printArray(int[] arr){
            System.out.print("[ ");
            int length = arr.length;

            for(int i = 0; i < length-1; i++){
                System.out.print(arr[i]+", ");
            }
            System.out.println(arr[length-1]+" ]");
        }

        public void insertionSortFunction(int[] arr, int iteration){

            if(iteration == arr.length)return;

            int j = iteration;
            while(j >0 && arr[j-1] > arr[j]){
                swap(arr, j-1, j);
                j--;
            }
            insertionSortFunction(arr, iteration + 1);

        }

        public void swap(int[] arr, int left, int right){
            int temporary = arr[left];
            arr[left] = arr[right];
            arr[right] = temporary;
        }

        public static void main(String[] args) {
            InsertionSortRecursive is = new InsertionSortRecursive();
            int[] arr = new int[]{2};
            //{2,5,3,1,-1,4};
            System.out.println("Array before: ");
            is.printArray(arr);
            is.insertionSortFunction(arr, 1);
            System.out.println("Array after insertion sort: ");
            is.printArray(arr);
        }

}