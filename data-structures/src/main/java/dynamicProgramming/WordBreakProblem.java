package dynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordBreakProblem {

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return checkWordBreak(s, words, new HashMap<>());
    }

    private static boolean checkWordBreak(String s, Set<String> words, Map<String,Boolean> dp) {
        if (s == null || s.isEmpty()) return true;
        if (dp.containsKey(s)) return dp.get(s);
        for (int i=1; i<=s.length();i++) {
            if (words.contains(s.substring(0,i)) && checkWordBreak(s.substring(i), words, dp)) {
                dp.put(s.substring(i), true);
                return true;
            }
        }
        dp.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> words = Stream.of("leet", "code").collect(Collectors.toList());
        System.out.println(wordBreak(s, words));

    }
}
