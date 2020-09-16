package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfPathsInMatrix {
    public static int numberOfPaths(List<List<Integer>> matrix) {
        // Write your code here
        int[][] matrixDP = new int[matrix.size()][matrix.get(0).size()];
        // first column
        boolean zeroFound = false;

        for(int i = 0;i<matrix.size();i++){
            if(!zeroFound && matrix.get(i).get(0) == 1){
                matrixDP[i][0] = 1;
            }else{
                matrixDP[i][0] = 0;
                zeroFound = true;
            }
        }
        //first row
        zeroFound = false;

        for(int i = 0;i<matrixDP[0].length;i++){
            if(!zeroFound && matrix.get(0).get(i) == 1){
                matrixDP[0][i] = 1;
            }else{
                matrixDP[0][i] = 0;
                zeroFound = true;
            }
        }

        // left to right, add both paths
        for(int j = 1;j<matrixDP.length;j++){
            for(int k = 1; k< matrixDP[j].length;k++){
                if(matrix.get(j).get(k) == 0){
                    matrixDP[j][k] = 0;
                }else {
                    matrixDP[j][k] = matrixDP[j - 1][k] + matrixDP[j][k - 1];
                }
            }
        }
        System.out.println(Arrays.deepToString(matrixDP));
        return matrixDP[matrixDP.length-1][matrixDP[0].length-1] ;

    }

    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);
        integerList.add(0);
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);

        List<Integer> integerList1 = new ArrayList<>();

        integerList1.add(1);
        integerList1.add(0);
        matrix.add(integerList);
//        matrix.add(integerList);
//        matrix.add(integerList);

//        System.out.println(numberOfPaths(matrix));

//        int i = 872846604;
        int modValue = new Double(Math.pow(10.0, 9.0) + 7.0).intValue();

        System.out.println(modValue);
        System.out.println(10^9+7);

//        System.out.println(i);
    }

}
