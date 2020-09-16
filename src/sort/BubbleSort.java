package sort;

public class BubbleSort {
    private static void bubbleSort(int[] arr){
        System.out.println("Array to sort is :");
        printArray(arr);
        if(arr == null || arr.length <= 1){
            System.out.println("Sorted Array is :");
            printArray(arr);
            return;
        }
        for(int i = 0; i < arr.length;i++ ){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("Sorted Array is :");
        printArray(arr);

    }


    public static void main(String[] args){
        int[] b = {9,3,6,4,8,1};
        bubbleSort(b);


        int[] c = {1,2,3,4,5,6};
        bubbleSort(c);

        int[] d = {9,8,7,6,5,4};
        bubbleSort(d);

        int[] e = {9,8,5,7,6,5,4};
        bubbleSort(e);

        int[] f= {};
        bubbleSort(f);

        int[] g= {5};
        bubbleSort(g);
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
