package dp;


import java.util.Arrays;

public class MaxStolenValue {
    // Recurrence equation
    // f(i) = values[i] + Max amongst all elements till i - 2 (inclusive) index
    static int maxStolenValue(int[] values) {
        if(values.length == 1){
            return values[0];
        }
        if(values.length == 2){
            return Math.max(values[0],values[1]);
        }
        int[] DP = new int[values.length];
        DP[0] = values[0];
        DP[1] = values[1];
        int maxForIMinus2Element = 0;

        for(int i = 2;i<values.length;i++){
            if(DP[i-2] > maxForIMinus2Element){
                maxForIMinus2Element = DP[i-2];
            }
            DP[i] = values[i]+maxForIMinus2Element;
        }
        return Math.max(DP[values.length-1],DP[values.length-2]);
    }

    public static void main(String[] args) {
        System.out.println(maxStolenValue(new int[]{1,2,4,5,1}));
    }
}
