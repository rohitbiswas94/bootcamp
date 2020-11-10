package strings;

import java.util.HashSet;
import java.util.Set;

public class SubsequencesOfString {

    private static void subSequences(final String string) {
        Set<String> set = new HashSet<>();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= i; j--) {
                String subString = string.substring(i, j + 1);
                set.add(subString);
                for (int k = 1; k < subString.length(); k++) {
                    StringBuilder stringBuffer = new StringBuilder(subString);
                    StringBuilder newSubSeq = stringBuffer.deleteCharAt(k);
                    if (!set.contains(newSubSeq)) {
                        set.add(newSubSeq.toString());
                    }
                }
            }
        }
        System.out.println(set.toString());
    }

    public static void main(String[] args) {
        String string = "abc";
        subSequences(string);
    }
}
