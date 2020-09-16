package recursion;

public class CheckIfSumPossible {
    static boolean check_if_sum_possible(long[] arr, long k) {
       int setIndex = 0;
       int arrIndex = 0;
       long sum = 0;
       return check_if_sum_possible_helper(arr,arrIndex,k,sum,setIndex);
    }

    private static boolean check_if_sum_possible_helper(long[] arr, int arrIndex, long target, long sum, int setIndex) {
        boolean result = false;
        if(sum == target && setIndex > 0){
            return true;
        }
        if(arrIndex == arr.length){
            return false;
        }

        // exclude
        result = check_if_sum_possible_helper(arr, arrIndex + 1,  target, sum,setIndex);
        if(result) return true;

        // include
        result = check_if_sum_possible_helper(arr,arrIndex+1,target,sum + arr[arrIndex], setIndex + 1);
        if(result) return true;
        return result;
    }


    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        long[] arr = {-5,-10};
        System.out.println(check_if_sum_possible(arr,-15));
        System.out.println(System.currentTimeMillis() - time);
    }
}
