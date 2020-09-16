import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    /*
     * Complete the function below.
     */
    static String[] findZeroSum(int[] arr) {
        // Write your code here.
        if(arr == null || arr.length < 3){
            return new String[0];
        }

        Arrays.sort(arr);
        Set<String> result= new HashSet();
        for(int i = 0;i<arr.length-2;i++){
            List<String> strList = find2Sum(arr,-arr[i],i+1);
            for(String str : strList){
                result.add(str);
            }
        }
        if(result.size() > 0){
            return result.toArray(new String[1]);
        }else{
            return new String[0];
        }
    }

    static List<String> find2Sum(int[] arr, int target, int startPos){
        int start = startPos;
        int end = arr.length - 1;
        List<String> strList = new ArrayList();
        while(start < end){
            if(arr[start] + arr[end] == target){
                strList.add(target*-1+","+arr[start]+","+arr[end]);
                start++;
                end--;
            }else if(arr[start]+arr[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return strList;
    }

    public static void main(String[] args){
        int[] arr = {3,12,34,-46};
        String[] zeroSum = findZeroSum(arr);
        for(String str:zeroSum) {
            System.out.println(str);
        }
    }
}
