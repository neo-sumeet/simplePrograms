package recursion;

import java.util.Arrays;

/**
 * Print all possible Binary Strings of length N (Example of Permuation with repetition)
 * You solve the problem by making teh choice for teh first digit and give the rest of the problem to the subordinate.
 * Subordinate keeps on delegating by reducing the problem size until the size of the problem is 0 when it's nothing to solve.
 * That means the partial solution in the slate is the solution we were looking for.
 *
 * Time complexity is O((2^n)n)  - the last n is to print the n itegeres in the slate which is done at the leaf node
 * Space complexity - O(n)
 *
 */
public class PrintBinaryStringsLengthN {

    public static void main(String[] args) {
        binaryStringGenerate(3);
    }

    private static void binaryStringGenerate(int n) {
        int[] arr = new int[3];
        binaryStringGenerateHelper( arr, n);
    }

    private static void binaryStringGenerateHelper(int[] arr, int remainingSize) {
        if (remainingSize <= 0){
            System.out.println(Arrays.toString(arr));
            return;
        }
        arr[arr.length - remainingSize] = 0;
        binaryStringGenerateHelper(arr,remainingSize-1);
        arr[arr.length - remainingSize] = 1;
        binaryStringGenerateHelper(arr,remainingSize-1);
    }

}
