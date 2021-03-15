/*
 Find the permutations of a small string in a big string.
 Ex : bigString = "cbaabcacabca", smallString = "abc"
 Ans = 6 [cba, abc, bca, cab, abc, bca]
 */

package strings;

import java.util.HashMap;
import java.util.Map;

public class PermutationsOfSmallStringInBigString {

    private static int permutations(final String bigString, final String smallString) {
        final Map<Character, Integer> smallStringCharMap = new HashMap<>();
        final Map<Character, Integer> bigStringCharMap = new HashMap<>();
        for (char c : smallString.toCharArray()) {
            smallStringCharMap.put(c, smallStringCharMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, k = smallString.length(), count = 0;
        for (int i = 0; i < k; i++) {
            bigStringCharMap.put(bigString.charAt(i), bigStringCharMap.getOrDefault(bigString.charAt(i), 0) + 1);
        }
        count = checkMapEquals(smallStringCharMap, bigStringCharMap) ? count + 1 : count;
        for (int i = k; i < bigString.length(); i++) {
            char prevWindowChar = bigString.charAt(l);
            bigStringCharMap.put(prevWindowChar, bigStringCharMap.get(prevWindowChar) - 1);
            if (bigStringCharMap.get(prevWindowChar) == 0) bigStringCharMap.remove(prevWindowChar);
            char newWindowChar = bigString.charAt(i);
            bigStringCharMap.put(newWindowChar, bigStringCharMap.getOrDefault(newWindowChar, 0) + 1);
            count = checkMapEquals(smallStringCharMap, bigStringCharMap) ? count + 1 : count;
            l++;
        }
        return count;
    }

    private static boolean checkMapEquals(Map<Character, Integer> smallMap, Map<Character, Integer> bigMap) {
        for (Map.Entry<Character, Integer> entry : bigMap.entrySet()) {
            if (!entry.getValue().equals(smallMap.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String bigString = "cbabcacabcacb";
        String smallString = "abc";
        System.out.println(permutations(bigString, smallString));
    }
}
