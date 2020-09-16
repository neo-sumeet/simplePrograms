package sort;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
    private static void quickSort(int[] arr){
        System.out.println("Array to sort is :");
        printArray(arr);
        quickSortHelper(arr,0,arr.length - 1);

        System.out.println("Sorted Array is :");
        printArray(arr);

    }

    // n is size of array
    private static void quickSortHelper(int[] arr,int start, int end){
//        System.out.println("Sorting array position "+start+" and "+end);
//        printArray(arr);

        if(start >= end){
            return;
        }
        // pick pivot element
        int pivotElementIndex = ThreadLocalRandom.current().nextInt(start,end);
        int pivotElement = arr[pivotElementIndex];
        swap(arr,start,pivotElementIndex);
        int orange = start;

        for(int green = start + 1;green<=end;green++) {
            if (arr[green] < pivotElement) {
                orange++;
                swap(arr,orange,green);
            }
        }

        swap(arr, start, orange);
        quickSortHelper(arr,start,orange-1);
        quickSortHelper(arr,orange+1,end);

    }

    private static void swap(int[] arr,int index1, int index2){
//        System.out.println("Swapping "+index1 +" and " +index2);
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args){
        int[] b = {9,3,6,4,8,1};
        quickSort(b);


        int[] c = {1,2,3,4,5,6};
        quickSort(c);

        int[] d = {9,8,7,6,5,4};
        quickSort(d);

        int[] e = {9,8,5,7,6,5,4};
        quickSort(e);

        int[] f= {};
        quickSort(f);

        int[] g= {5};
        quickSort(g);
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

