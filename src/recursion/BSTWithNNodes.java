package recursion;

import java.util.HashMap;
import java.util.Map;

public class BSTWithNNodes {

    static Map<Integer,Long> howManyBstMap = new HashMap<>();
    static long how_many_BSTs(int n) {
        if(n <= 1){
            return 1;
        }
        if(howManyBstMap.containsKey(n)){
            return howManyBstMap.get(n);
        }
        long result = 0;
        for(int i = 0; i< n;i++) {
            result += how_many_BSTs(i) * how_many_BSTs(n-i-1);
        }
        howManyBstMap.put(n,result);
        return result;
    }



    public static void main(String[] args) {
        long time = System.nanoTime();
        System.out.println(how_many_BSTs(20));
        long time2 = System.nanoTime() - time;
        System.out.println("Time taken = "+time2);
    }
}
// 2426188403
//     896116