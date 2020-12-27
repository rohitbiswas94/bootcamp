package strings;

public class MinimumDistanceBetween2WordsInStringI {

    private static int minimumDistance(String sentence, String word1, String word2) {
        if (word1.equalsIgnoreCase(word2)) return 0;
        String[] words = sentence.split(" ");
        int wordFoundAtIndex = 0;
        int index = 0;
        int minDistance = words.length + 1;
        while (index < words.length) {
            if (words[index].equalsIgnoreCase(word1) || words[index].equalsIgnoreCase(word2)) {
                wordFoundAtIndex = index;
                break;
            }
            index++;
        }
        while (index < words.length) {
            if (words[index].equalsIgnoreCase(word1) || words[index].equalsIgnoreCase(word2)) {
                if (!words[wordFoundAtIndex].equalsIgnoreCase(words[index])
                        && (index - wordFoundAtIndex - 1) <= minDistance) {
                    minDistance = index - wordFoundAtIndex - 1;
                    wordFoundAtIndex = index;
                } else {
                    wordFoundAtIndex = index;
                }
            }
            index++;
        }
        return minDistance;
    }

    public static void main(String[] args) {
        String sentence = "geeks for geeks contribute practice";
        String word1 = "geeks";
        String word2 = "practice";
        System.out.println(minimumDistance(sentence, word1, word2));
    }
}
