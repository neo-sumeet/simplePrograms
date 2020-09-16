package sort;

import java.util.Arrays;

public class BubbleSortPractice {

    public void bubblesort(int[] arr){
        if(arr == null || arr.length <=1 ) return;

        for(int i = 0;i < arr.length - 1;i++){
            for(int j = arr.length - 1 ; j>i ;j--){
                if(arr[j-1] > arr[j]){
                    swap(arr,j-1,j);
                }
            }
            System.out.println(Arrays.toString(arr));

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        BubbleSortPractice sort = new BubbleSortPractice();
        int[] arr = {9,8,7,6,5,4};
        sort.bubblesort(arr);
    }
}
