package sort;

public class SelectionSort {

    private static void selectionSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }
        for(int i = 0; i < arr.length - 1;i++ ){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args){
//        int[] b = {9,3,6,4,8,1};
//        int[] b = {1,2,3,4,5,6};
//        int[] b = {9,8,7,6,5,4};
        int[] b = {9,8,5,7,6,5,4};


        selectionSort(b);
        for(int i =0;i<b.length;i++){
            System.out.println(b[i]);
        }

    }
}
