package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class StringTransformation {

    static String[] string_transformation(String[] words, String start, String stop) {
        // Part 1 Build Graph
        Map<String, Map<String, Integer>> mapAdjMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        Map<String, String> visited = new HashMap<>();
        visited.put(start, null);
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();

            // neighboirs can be all vertices but with a single char diff
            if (findCharDiff(node,stop)) {
                result.add(stop);
                while (node != null) {
                    result.add(node);
                    node = visited.get(node);
                }
                Collections.reverse(result);
                return result.toArray(new String[0]);
            }
            for (int i = 0; i < words.length; i++) {
                if (!visited.containsKey(words[i]) && findCharDiff(words[i], node)) {
                    queue.add(words[i]);
//                    System.out.println("Adding "+words[i]+" with parent "+node);
                    visited.put(words[i], node);
                }
            }
        }
        return new String[] {"-1" };

        // Part 2 BFS


    }

    private static boolean findCharDiff(String word, String node) {
        char[] nodeCharArray = node.toCharArray();
        char[] wordCharArray = word.toCharArray();
        boolean diff = false;
        for (int i = 0; i < word.length(); i++) {
            if (nodeCharArray[i] != wordCharArray[i]) {
                if (!diff) {
                    diff = true;
                } else {
                    return false;
                }
            }
        }
//        System.out.println("Checking difference between "+word+" and "+node+", returning "+diff);
        return diff;
    }

    public static void main(String[] args) {
        String[] strings = {"cat", "hat", "bad", "had" };

        Arrays.stream(string_transformation(strings, "bat", "had")).forEach(x -> System.out.println(x));

    }
}
