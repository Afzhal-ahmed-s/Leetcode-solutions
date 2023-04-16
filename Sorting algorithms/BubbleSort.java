class BubbleSort{

    public void bubbleSortFunction(int[] arr){

        int length = arr.length;
        boolean alreadySorted = true;

        for(int i=0; i<length-1; i++){
            for(int j=0; j<length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    //Pass by reference
                    swap(arr, j, j+1);
                    alreadySorted = false;
                } 
            }
            if(alreadySorted)break;
        }
        //System.out.println("alreadySorted status : "+alreadySorted);
        for(int i=0; i<length; i++){
        System.out.print(arr[i]+", ");
        }

    }

    //Pass by reference
    public void swap(int[] arr, int left, int right){
        int temporary = arr[left];
        arr[left] = arr[right];
        arr[right] = temporary;
    }
    
    public static void main(String[] args){
        BubbleSort bS = new BubbleSort();
        int[] arr = new int[]{7,5,1,2,4,3,6};
        int[] arr2 = new int[]{1,2,3,4,5};
        bS.bubbleSortFunction(arr);
    }

}