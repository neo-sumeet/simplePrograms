package dp;

import java.util.Arrays;

public class LevenshteinDistance {
    static int levenshteinDistance(String strWord1, String strWord2) {
        /*
         * Write your code here.
         */
        // 1. IDentify DP table
        int[][] DP = new int[strWord1.length()+1][strWord2.length()+1];

        // 2. Initialize DP table
        DP[strWord1.length()][strWord2.length()] = 0;
        for(int i = 0;i < strWord2.length();i++){
            DP[strWord1.length()][i]=strWord2.length() - i;
        }

        for(int i = 0;i < strWord1.length();i++){
            DP[i][strWord2.length()]=strWord1.length() - i;
        }

        // Find traversal direction and populate dp table
        for(int i = strWord1.length()-1; i >= 0 ;i--){
            for(int j = strWord2.length()-1; j >=0;j--){
                if(strWord1.charAt(i) == strWord2.charAt(j)){
                    DP[i][j] =  DP[i+1][j+1];
                }else {
                    DP[i][j] =   1 + min3(DP[i][j+1],DP[i+1][j],DP[i+1][j+1]);
                }
            }
        }
//        Arrays.stream(DP).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println(Arrays.deepToString(DP).replaceAll("],","],\n"));
        return DP[0][0];
    }

    static int min3(int val1, int val2, int val3){
        return Math.min(Math.min(val1,val2),val3);
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("word1","word2"));
    }
}
