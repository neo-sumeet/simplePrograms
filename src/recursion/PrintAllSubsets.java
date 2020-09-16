package recursion;

import java.util.Arrays;

public class PrintAllSubsets {

    /**
     * Subset generation follow the inclusin / exclusion pattern
     * You make the choce on the first character to include on exclude and pass the remaining array down
     *
     * You have to mainitain slateIndex to pop / overwrite the elements when you come back from DFS recursion and follow the other path
     *
     * Time Complexit = O(2^n * n)
     * @param args
     */
    public static void main(String[] args) {
        String str = "123";
        subset(str);
    }

    private static void subset(String str) {
       char[] slate = new char[str.length()];
       subsetHelper(slate,0,str,0);
    }

    private static void subsetHelper(char[] slate, int slateIndex, String str, int strIndex) {
        if(str.length() == strIndex){
            printArray(slate,slateIndex);
            return;
        }
        // exclude
        subsetHelper(slate,slateIndex,str,++strIndex);
        strIndex--;
        // include
        slate[slateIndex++] = str.charAt(strIndex);
        subsetHelper(slate,slateIndex,str,++strIndex);
        slateIndex--;
        strIndex--;
    }

    private static void printArray(char[] slate, int slateIndex){
        for(int i = 0;i<slateIndex;i++){
            System.out.print(slate[i]);

        }
        System.out.println("");




    }
}
