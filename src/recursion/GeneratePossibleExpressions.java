package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GeneratePossibleExpressions {
    /*
     * Complete the function below.
     */
    static String[] generate_all_expressions(String s, long target) {
        ArrayList<String> strings = new ArrayList<String>();
        generateExpression(s.substring(1),target,s.substring(0,1), strings);
        return strings.toArray(new String[0]);
    }

    static void generateExpression(String remainingString, long target, String exprString,  List<String> exprList){
        long currentSum = evalExprValue(exprString);
        if(remainingString.length() == 0 && currentSum == target){
            exprList.add(exprString);
            return;
        }
        else if(remainingString.length() == 0){
            return;
        }

        char c = remainingString.charAt(0);
        int value = Integer.valueOf(c);
        long tempSum = currentSum;

        // join expression
        currentSum = currentSum * 10 + value;
        generateExpression(remainingString.substring(1),target,exprString+c,exprList);
        // multiplicatin expression
        currentSum = currentSum * value;
        generateExpression(remainingString.substring(1),target,exprString+'*'+c,exprList);
        // plus expression
        currentSum = currentSum + value;
        generateExpression(remainingString.substring(1),target,exprString+'+'+c,exprList);
    }

    static long evalExprValue(String exprString){
        String[] plusSplit = exprString.split("\\+");
        long sumValue = 0;
        if(plusSplit.length > 0){
            for(String plusStr : plusSplit){
                long result = 1;
                String[] mulSplit = plusStr.split("\\*");
                if(mulSplit.length > 0){
                    for (String mulStr : mulSplit) {
                        result = result * Long.valueOf(mulStr);
                    }
                    sumValue = sumValue + result;
                }
            }
        }
        return sumValue;
    }

    public static void main(String[] args) {
        generate_all_expressions("6666666666666",6);
    }
}
