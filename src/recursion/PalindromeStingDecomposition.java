package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PalindromeStingDecomposition {
    static String[] generate_palindromic_decompositions(String s) {
        Collection<String> results = new ArrayList<>();
        if (s.length() <= 1) {
            results.add(s);
        } else {
            char[] buffer = new char[s.length()*2];
            generate(s, 0, buffer, 0, results);
        }
        return results.stream().toArray(String[]::new);
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    static void generate(String s, int i, char[] buffer, int b, Collection<String> results) {
        if (i >= s.length()) {
            if (buffer[b-1] == '|') {
                results.add(new String(buffer, 0, b-1));
            } else {
                results.add(new String(buffer, 0, b));
            }
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                for (int k = i; k <= j; k++) {
                    buffer[b++] = s.charAt(k);
                }
                buffer[b++] = '|';
                generate(s, j+1, buffer, b, results);
                b--;// for the delim
                b -= (j-i)+1; // for the current palindrone. There might be a 'longer' palindrome coming in the next loop!
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate_palindromic_decompositions("aaaaaa")));
    }
}
