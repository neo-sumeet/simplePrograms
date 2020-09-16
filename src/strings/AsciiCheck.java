package strings;

public class AsciiCheck {
    public static void main(String[] args) {
        char c = 'a';
        System.out.println((int)c);
        String S = "abc";
        StringBuilder sb = new StringBuilder();
        S.chars().filter(value -> value != 'a').forEach(value -> sb.append((char)value));
        System.out.println(sb.toString());
        long val = 0;
        val = val | ( 1L << 32);
        System.out.println(val );
        int x = 8;
        System.out.println(val & x );
    }
}
