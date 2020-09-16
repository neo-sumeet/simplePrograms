package recursion;

import java.util.Arrays;

/**
 * Print all possible Decimal Strings of length N (Example of Permuation with repetition)
 * You solve the problem by making teh choice for teh first digit and give the rest of the problem to the subordinate.
 * Subordinate keeps on delegating by reducing the problem size until the size of the problem is 0 when it's nothing to solve.
 * That means the partial solution in the slate is the solution we were looking for.
 *
 * Time complexity is O((2^n)n)  - the last n is to print the n itegeres in the slate which is done at the leaf node
 * Space complexity - O(n)
 *
 */
public class PrintDecimalStringsLengthN {

    public static void main(String[] args) {
        decimalStringGenerate(3);
    }

    private static void decimalStringGenerate(int n) {
        int[] arr = new int[3];
        decimalStringGenerateHelper( arr, n);
    }

    private static void decimalStringGenerateHelper(int[] arr, int remainingSize) {
        if (remainingSize <= 0) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i <= 9; i++){
            arr[arr.length - remainingSize] = i;
            decimalStringGenerateHelper(arr, remainingSize - 1);
        }
    }

}
