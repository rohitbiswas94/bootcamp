package strings;

public class Anagrams {

    private static int anagram(String s) {
        int len = s.length(), count = 0;
        if (len % 2 != 0) return -1;
        String s1 = s.substring(0, len / 2);
        String s2 = s.substring(len / 2, len);
        char[] s1Chars = s1.toCharArray();
        for (char c : s1Chars) {
            int index = s2.indexOf(c);
            if (index == -1) {
                count++;
            } else {
                s2 = s2.substring(0, index) + s2.substring(index + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "0003187610";
        System.out.println(anagram(s));
    }
}
