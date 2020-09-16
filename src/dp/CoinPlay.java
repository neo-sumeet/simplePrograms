package dp;

import java.util.Arrays;

public class CoinPlay {

    static int maxWin(int[] v) {
        int[][] DP = new int[v.length+1][v.length+1];

        DP[0][0]=0;
        for(int row = 0;row < DP.length;row++){
            for(int col = 0;col < row;col++) {
                DP[row][col] = 0;
            }
        }

        for(int i =  v.length-1; i>=0 ;i-- ){
            for(int j = v.length - 1 ;j >= i ; j--){
                if(i == j){
                    DP[i][j] = v[i];
                }else if(i == j+1){
                    DP[i][j] = Math.max(v[i],v[j]);
                }else{
                    int x = i + 1 > j - 1 ? 0 : DP[i + 1][j - 1];
                    int y = i + 2 > j ? 0 : DP[i + 2][j];
                    int z = i > j-2 ? 0 : DP[i][j - 2];
                    DP[i][j] = Math.max(v[i]+Math.min(x, y),v[j]+Math.min(x, z));
                }
            }
        }
        return DP[0][v.length];
    }

    public static void main(String[] args) {
        System.out.println(maxWin(new int[]{8,15,3,7}));
    }
}
