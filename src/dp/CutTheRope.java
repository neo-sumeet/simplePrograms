package dp;

import java.util.Arrays;

public class CutTheRope {
    /*
     * Complete the max_product_from_cut_pieces function below.
     *
     * Recurrence relation
     *
     * f(n) = Max of (max(f(l),l) * max(f(n-l),n-l)) over all possible n/2 lengths
     */
    static long max_product_from_cut_pieces(int n) {
        /*
         * Write your code here.
         */
        long[] DP = new long[n+1];
        DP[0] = 1;
        DP[1] = 1;
        for(int i = 2; i<DP.length; i++){
            long max = 0;
            for(int l = 1; l <= i/2; l++){
                long maxProd = Math.max(DP[l],l) * Math.max(DP[i-l],i-l);
                if(max < maxProd){
                    max = maxProd;
                }
            }
            DP[i] = max;
        }
//        System.out.println(Arrays.toString(DP));
        return DP[n];
    }

    public static void main(String[] args) {
        System.out.println(max_product_from_cut_pieces(63));
    }
}
