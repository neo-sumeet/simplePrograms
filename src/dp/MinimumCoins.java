package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCoins {

    // Recurrence formula
    // Min(For all 0..coincount F(n - coin[i])  base case if value == 1, count is 1
    public static int minimum_coins(List<Integer> coins, int value) {
        // Write your code here
        int[] DP = new int[value+1];
        DP[0] = 0;
        DP[1] = 1;

        for(int sum = 2; sum < DP.length;sum++){
            int min = 9999;
            for(int j=0;j<coins.size();j++){
                int coinValue = coins.get(j).intValue();
                int valDiff = sum  - coinValue;
                if(valDiff == 0){
                    min = 1;
                    break;
                }else if(valDiff > 0 && min >  1 + DP[valDiff]){
                    min = 1 + DP[valDiff];
                }
            }
            DP[sum] =  min;
        }
        System.out.println(Arrays.toString(DP));
        return DP[value];
    }

    public static void main(String[] args) {
        List coinList = Arrays.asList(new Integer[]{1,3,8});
        System.out.println(minimum_coins(coinList,9));
    }

}
