package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindAllWellFormedBrackets {

    static String[] find_all_well_formed_brackets(int n) {
        List<String> list = new ArrayList<>();

        int weight = 0;
        int index = 0;
        char[] strSoFar = new char[2*n];
        find_all_well_formed_brackets_helper(list,weight,index,strSoFar,n);
        return list.toArray(new String[0]);
    }

    private static final char LB = '(';
    private static final char RB = ')';

    private static void find_all_well_formed_brackets_helper(List<String> list, int weight, int index, char[] strSoFar, int n) {
        if(index == 2 * n && weight == 0){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i< index;i++){
                sb.append(strSoFar[i]);
            }
            list.add(sb.toString());
            return;
        }
        if(weight < 0 || index >= strSoFar.length){
            return;
        }

        // include LB
        strSoFar[index] = LB;
        find_all_well_formed_brackets_helper(list,weight+1,index+1,strSoFar,n);

        // include RB
        strSoFar[index] = RB;
        find_all_well_formed_brackets_helper(list,weight-1,index+1,strSoFar,n);

    }

    public static void main(String[] args) {
        String[] all_well_formed_brackets = find_all_well_formed_brackets(3);
        System.out.println(Arrays.toString(all_well_formed_brackets));
    }
}
