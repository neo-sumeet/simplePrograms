package sort;

import java.util.Arrays;

public class SelectionSortPractice {

    public void selectionsort(int[] arr){
        if(arr == null || arr.length <= 1) return;

        for(int i = 0; i< arr.length - 1;i++){
            int min = i;
            for(int j = i+1; j<arr.length;j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
        }
        System.out.println(Arrays.toString(arr));

    }

    private void swap(int[] arr, int i, int min) {
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
    }

    public static void main(String[] args) {
        SelectionSortPractice sort = new SelectionSortPractice();
        int[] arr = {6,2,8,1,9,7};
        sort.selectionsort( arr);
    }
}
