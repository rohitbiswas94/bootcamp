package strings;

import java.util.HashSet;
import java.util.Set;

 /*
  Sliding window concept
  A sliding window is an abstract concept commonly used in array/string problems.
  A window is a range of elements in the array/string which usually defined by the start and end indices,
  i.e. [i,j)[i, j)[i,j) (left-closed, right-open). A sliding window is a window "slides" its two boundaries
  to the certain direction. For example, if we slide [i,j)[i, j)[i,j) to the right by 111 element,
  then it becomes [i+1,j+1)[i+1, j+1)[i+1,j+1) (left-closed, right-open).
  */
public class LongestSubstringUniqueCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxSubStringLength = 0;
        int i = 0, j = 0;
        Set<Character> charSet = new HashSet<>();
        while (i < n && j < n) {
            if (!charSet.contains(s.charAt(j))) {
                charSet.add(s.charAt(j));
                maxSubStringLength = Math.max(maxSubStringLength, 1 + (j - i));
                j++;
            } else {
                charSet.remove(s.charAt(i));
                i++;
            }
        }
        return maxSubStringLength;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
