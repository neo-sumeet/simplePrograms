package sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortHoares {



    public static void main(String[] args){
//        int[] arr = {5,7,8,9,3,2,7,5,9,1};

//        int[] arr = {1};
//        int[] arr = {9,9,8,8,7,7,6,6,5,5,4,4,3,3,2,2,1,1};
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9};

        quicksort3way(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort3way(int[] arr,int start,int end) {
        if(start >= end){
            return;
        }
        int[] leftRightIndex = partition(arr,start,end);
        quicksort3way(arr,start, leftRightIndex[0] - 1);
        quicksort3way(arr,leftRightIndex[1]+1,end);
    }

    private static int[] partition(int[] arr, int start, int end) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(start,end);
        int pivot = arr[pivotIndex];
        int left = start;
        int right = end;
        int current = start;
        while(current <= right){
            if(arr[current]  < pivot){
                swap(arr,left,current);
                left++;
                current++;
            }else if(arr[current] > pivot){
                swap(arr,current,right);
                right--;
            }else{
                current++;
            }
        }
//        System.out.println("-----------("+start+","+end+":::"+pivot+")-------------");
//        System.out.println(Arrays.toString(arr));
//        System.out.println("-----------------------------------");

        return new int[]{left,right};
    }

    private static void swap(int[] arr, int index1, int index2){
//        System.out.println("Swapping "+arr[index1]+" and "+arr[index2]);
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
