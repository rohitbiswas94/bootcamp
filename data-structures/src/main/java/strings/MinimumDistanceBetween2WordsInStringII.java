/*
    Given a String and two words (which occur in the given string), find the minimum distance between two words.
    Distance between two words is defined as the number of characters between the given two words’ middle characters.
 */
package strings;

public class MinimumDistanceBetween2WordsInStringII {

    private static int minimumDistance(String sentence, String word1, String word2) {
        if (word1.equalsIgnoreCase(word2)) return 0;
        String[] words = sentence.split(" ");
        int wordFoundAtIndex = -1;
        int index = 0;
        while (index < words.length) {
            if (words[index].equalsIgnoreCase(word1) || words[index].equalsIgnoreCase(word2)) {
                wordFoundAtIndex = index;
                break;
            }
            index++;
        }
        if (wordFoundAtIndex == -1) return -1;
        int minCharacters = Integer.MAX_VALUE;
        int characters = 0;
        while (index < words.length) {
            if (words[index].equalsIgnoreCase(word1) || words[index].equalsIgnoreCase(word2)) {
                if (!words[wordFoundAtIndex].equalsIgnoreCase(words[index])) {
                    minCharacters = Math.min(minCharacters, characters);
                    wordFoundAtIndex = index;
                } else {
                    wordFoundAtIndex = index;
                }
             } else {
                characters += words[index].length();
            }
            index++;
        }
        minCharacters += word1.length()/2 + word2.length()/2 - 2;
        return minCharacters;
    }

    public static void main(String[] args) {
        String sentence = "geeks for geeks contribute practice";
        String word1 = "geeks";
        String word2 = "practice";
        System.out.println(minimumDistance(sentence, word1, word2));
    }
}
