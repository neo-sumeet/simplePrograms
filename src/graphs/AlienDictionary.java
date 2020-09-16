package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class AlienDictionary {
    static Map<Character,Set<Character>> graphMap= new HashMap<>();
    static Map<Character,Integer> arrivalMap = new HashMap<>();
    static Map<Integer,Character> departureMap = new TreeMap<>();
    static Map<Character,Integer> visitedMap = new HashMap<>();


    static String find_order(String[] words) {
        // build graph
        // scan adjacent words for edges
        for(int i = 0;i< words.length;i++){
            findAndAddEdge(words,i);
        }


        // now do dfs topological sort
        graphMap.keySet().stream().forEach(character -> {
            if(visitedMap.get(character) == null)
                 dfs(character);
        });

        StringBuilder sb = new StringBuilder();
        departureMap.keySet().stream().sorted((time1,time2) -> -1 * (time1 - time2)).forEach( key ->  sb.append(departureMap.get(key)));
        return sb.toString();

    }

   static void findAndAddEdge(String[] words, int pos){
        String srcWord = words[pos];
        String dstWord = null;
        if(pos < words.length -1){
            dstWord = words[pos+1];
        }

        for(int i = 0;i<srcWord.length();i++){
            char srcChar = srcWord.charAt(i);
            Set<Character> characterSet = graphMap.get(srcChar);
            if (characterSet == null) {
                characterSet = new LinkedHashSet<>();
            }

            if(dstWord == null){
                graphMap.put(srcChar, characterSet);
                break;
            }else {
                char dstChar = dstWord.charAt(i);
                if (srcChar != dstChar) {
                    characterSet.add(dstChar);
                    graphMap.put(srcChar, characterSet);
                    break;
                }
            }
        }
   }
   static int time = 0;
   static void dfs(char c){
       visitedMap.put(c, 1);
       arrivalMap.put(c,time++);
       Set<Character> characters = graphMap.get(c);
       if(characters != null) {
           for (Character character : characters) {
               if (visitedMap.get(character) == null) {
                   dfs(character);
               }
           }
       }
       departureMap.put(time++,c);
   }

    public static void main(String[] args) {
        System.out.println(find_order(new String[]{"v", "ccvvhcc", "ccvvvhh"}));
    }
}
