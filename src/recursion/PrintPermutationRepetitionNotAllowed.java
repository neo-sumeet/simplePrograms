package recursion;

import java.util.Arrays;

/**
 * Print all possible permutation of characters in string without repetition)
 * You solve the problem by making the choice for the first character and put in the slate and give the rest of the string omitting that character to be solved.
 * Subordinate keeps on delegating by reducing the problem size until the size of the problem is 0 when it's nothing to solve.
 * That means the partial solution in the slate is the solution we were looking for.
 *
 * Time complexity is O((2^n)n)  - the last n is to print the n itegeres in the slate which is done at the leaf node
 * Space complexity - O(n)
 *
 */
public class PrintPermutationRepetitionNotAllowed {

    public static void main(String[] args) {
        permuteWithoutRepetition("abcd");
    }

    private static void permuteWithoutRepetition(String str) {
        char[] slate = new char[str.length()];
        permuteWithoutRepetitionHelper( slate, str);
    }

    private static void permuteWithoutRepetitionHelper(char[] slate, String remainingStr) {
//        System.out.println(remainingStr);
        if (remainingStr.length() <= 0) {
            System.out.println("---"+Arrays.toString(slate));
            return;
        }
        for (int i = 0; i < remainingStr.length(); i++){
            slate[slate.length - remainingStr.length()] = remainingStr.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(i > 0){
                sb.append(remainingStr.substring(0,i));
            }
            if(i+1 < remainingStr.length()){
                sb.append(remainingStr.substring(i+1,remainingStr.length()));
            }
            permuteWithoutRepetitionHelper(slate, sb.toString());
        }
    }

}
