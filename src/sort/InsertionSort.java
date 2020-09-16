package sort;

public class InsertionSort {
    private static void insertionSort(int[] arr){
        System.out.println("Array to sort is :");
        printArray(arr);
        insertionSortHelper(arr,arr.length);

        System.out.println("Sorted Array is :");
        printArray(arr);

    }

    // n is size of array
    private static void insertionSortHelper(int[] arr,int n){
        if(n <= 1){
            return;
        }
        insertionSortHelper(arr,n-1);
        int value = arr[n-1];
        int j = n - 2 ;
        while(j >= 0 && arr[j] > value){
            arr[j+1] = arr[j];
            j --;
        }
        arr[j+1]= value;
    }


    public static void main(String[] args){
        int[] b = {9,3,6,4,8,1};
        insertionSort(b);


        int[] c = {1,2,3,4,5,6};
        insertionSort(c);

        int[] d = {9,8,7,6,5,4};
        insertionSort(d);

        int[] e = {9,8,5,7,6,5,4};
        insertionSort(e);

        int[] f= {};
        insertionSort(f);

        int[] g= {5};
        insertionSort(g);
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
