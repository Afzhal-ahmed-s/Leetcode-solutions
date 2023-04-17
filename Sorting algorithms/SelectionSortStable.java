class SelectionSortable{

    public void selectionSortStableFunction(int[] arr){

        int length = arr.length;

        for(int i=0; i<length-1; i++){

            int min=i;

            for(int j=i+1; j<length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            int minNumber = arr[min];

            while(min > i){
                arr[min] = arr[min-1];
                min--;
            }
            arr[i] = minNumber;            

        }

        for(int k=0; k<length; k++){
            System.out.print(arr[k]+" ");
        }
        
    }


    public static void main(String[] args) {
        
    SelectionSortable ssS = new SelectionSortable();
    int[] arr= new int[]{100,7,5,4,3,2,6,4,1};
    ssS.selectionSortStableFunction(arr);
    }

}