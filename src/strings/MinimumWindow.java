package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Use Sliding window algorithm which will expand, stop and save result, then contract. When one character goes missing, it starts expanding again till end of string is reached.
 *
 *
 *
 */
class MinimumWindow {
    static class MinimumWindowResult {
        int start = -1;
        int end = -1;
    }


    /*
     * Complete the 'minimum_window' function below.
     *
     * The function accepts STRING s and STRING t as parameter.
     */



    public static String minimum_window(String s, String t) {
        // Write your code here

        Map<Character,Integer> charFoundMap = new HashMap<>();
        initializeMap(t,charFoundMap);
        int missing = t.length();
        int left = 0;
        int right= -1;
        MinimumWindowResult mwResult = new MinimumWindowResult();
        // keep expanding until missing > 0 and right < s.length

        while(missing > 0 && right < s.length() - 1){
            right++;

            char encounteredChar = s.charAt(right);
            if(t.indexOf(encounteredChar) != -1 ){
                Integer numOfCharsFound = charFoundMap.get(encounteredChar);
                if(numOfCharsFound >= 0){
                    missing--;
                }
                numOfCharsFound = numOfCharsFound + 1;
                charFoundMap.put(encounteredChar,numOfCharsFound);
            }


            // once saved, start contracting

            // start dropping left char, unitl missing becomes more than zero

            while(missing == 0){
                // save result
                saveResult(mwResult,left,right);

                char charToDrop = s.charAt(left);
                if(t.indexOf(charToDrop) != -1 ){
                    Integer timesCharFound = charFoundMap.get(charToDrop);
                    timesCharFound--;
                    charFoundMap.put(charToDrop,timesCharFound);
                    System.out.println("Subtracting char "+charFoundMap+" to "+charFoundMap);

                    if(timesCharFound == 0){
                        missing++;
                    }

                }
                System.out.println("Missing is "+missing);
                left++;
            }


        }

        if(mwResult.start == -1){
            return "-1";
        }

        return s.substring(mwResult.start,mwResult.end+1);

    }

    private static void saveResult(MinimumWindowResult mwResult, int left, int right) {
        int savedWindowLength = mwResult.end - mwResult.start + 1;
        int newWindowLength = right - left + 1;

        if(mwResult.start < 0 || savedWindowLength > newWindowLength){
            System.out.println("Saving result "+left+", "+right);
            mwResult.start = left;
            mwResult.end = right;
        }
    }

    private static void initializeMap(String t, Map<Character, Integer> charFoundMap) {
        char[] chars = t.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(charFoundMap.containsKey(chars[i])){
                Integer numOfCharsNeeded = charFoundMap.get(chars[i]);
                charFoundMap.put(chars[i], ++numOfCharsNeeded);
            }else {
                charFoundMap.put(chars[i], 0);
            }
        }
    }



    public static void main(String[] args) {
        MinimumWindow minimumWindow = new MinimumWindow();
        System.out.println(minimumWindow.minimum_window("abcda","aa"));
    }
}
