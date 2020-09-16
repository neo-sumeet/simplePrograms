package dp;

import java.util.Arrays;

public class NthStair {
    // recurrence equation
    // f(n) = summation of all possible step counts of f(n - steps[i])
    static long countWaysToClimb(int[] steps, int n) {
        long[] DP = new long[n+1];

        DP[0] = 1;

        // populate DP
        for(int i = 1;i<DP.length;i++){
            long numOfSteps = 0;
            for(int j = 0;j<steps.length;j++){
                if(i - steps[j] >= 0) {
                    numOfSteps += DP[i - steps[j]];
                }
            }
            DP[i] = numOfSteps;

        }
//        System.out.println(Arrays.toString(DP));
        return DP[n];
    }

    public static void main(String[] args) {
        System.out.println(countWaysToClimb(new int[]{2,3},7));
    }
}
