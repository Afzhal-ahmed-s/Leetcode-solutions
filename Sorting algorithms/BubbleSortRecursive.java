public class BubbleSortRecursive {
    

    public void printArray(int[] arr){
        int length = arr.length;
        System.out.print("The array is: [ ");

        for(int i=0; i<length-1; i++){
            System.out.print(arr[i]+", ");
        }

        System.out.print(arr[length-1]+ " ]");
        System.out.println();
    }

    public void bubbleSort(int[] arr){

        int length = arr.length;

        for(int i=0; i<length-1; i++){
            Boolean[] allSortedAlready = new Boolean[]{true};

            //Recursive call
            helper(arr,length, 0, length-1-i, allSortedAlready);

            //Enhancement
            if(allSortedAlready[0]){
                System.out.println("Input array already sorted, hence breaking the loop.");
                break;
            }
        }

    }

    public void helper(int[] arr, int lengthOfArray, int startIndex, int endIndex, Boolean[] allSortedAlready){

        if(startIndex == endIndex)return;

        if(arr[startIndex] > arr[startIndex + 1]){
            swap(arr, startIndex, startIndex + 1);
            allSortedAlready[0] = false;
        }

       //For understanding and debugging
       //System.out.println("Check: "+ startIndex+", "+endIndex+" - "+allSortedAlready[0]);
       //printArray(arr);
        helper(arr, lengthOfArray, startIndex + 1, endIndex, allSortedAlready);
    }

    public void swap(int[] arr, int left, int right){
        int temporary = arr[left];
        arr[left] = arr[right];
        arr[right] = temporary;
    }

    public static void main(String[] args){
        BubbleSortRecursive bsR = new BubbleSortRecursive();
        int[] arr = new int[]{3,5,1,2,4};
        int[] arr2 = new int[]{1,2,3,4,5,234};

        System.out.println("Array before Bubble sort recursion:");
        bsR.printArray(arr);
        bsR.bubbleSort(arr);
        System.out.println("Array after Bubble sort recursion:");
        bsR.printArray(arr);

    }

}
