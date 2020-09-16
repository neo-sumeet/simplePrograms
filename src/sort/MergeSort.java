package sort;

import java.util.Arrays;

public class MergeSort {
    private void mergeSort(int[] arr){
//        aux = new int[arr.length];
        System.out.println("Array to sort is :");
        printArray(arr);
         mergeSortHelper(arr, arr.length );

        System.out.println("Sorted Array is :");
        printArray(arr);

    }

    // n is size of array
    private void mergeSortHelper(int[] arr,int n) {
        if (n < 2) {
            return ;
        }
        int mid = (n) / 2;
        int[] leftArray = Arrays.copyOfRange(arr,0,mid);
        int[] rightArray = Arrays.copyOfRange(arr,mid,n);

        mergeSortHelper(leftArray, mid);
        mergeSortHelper(rightArray, n-mid);
        merge(arr,leftArray,rightArray,mid,n-mid);
    }

    private void merge(int[] arr, int[] leftArray, int[] rightArray, int leftArraySize, int rightArraySize) {


        int i = 0, j = 0,index=0;


        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] < rightArray[j]) {
                arr[index] = leftArray[i];
                i++;
            }else{
                arr[index]= rightArray[j];
                j++;
            }
            index++;
        }
        while(i< leftArraySize){
            arr[index++]=leftArray[i++];
        }
        while(j< rightArraySize){
            arr[index++]=rightArray[j++];
        }

    }


    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort();
        int[] b = {9,3,6,4,8,1};
        mergeSort.mergeSort(b);


        int[] c = {1,2,3,4,5,6};
        mergeSort.mergeSort(c);

        int[] d = {9,8,7,6,5,4};
        mergeSort.mergeSort(d);

        int[] e = {9,8,5,7,6,5,4};
        mergeSort.mergeSort(e);

        int[] f= {};
        mergeSort.mergeSort(f);

        int[] g= {5};
        mergeSort.mergeSort(g);
    }


    private static void printArray(int[] a){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length;i++ ) {
            sb.append(a[i]);
            if(i < a.length  - 1) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        System.out.print(sb.toString());

    }
}
