package strings;

public class ReverseWordsInSentence {

    private static void reverse(String[] words) {
        if (words.length == 1)
            System.out.println(words[0]);
        for (int i = words.length - 2; i >= 0; i--) {
            words[i] = words[i + 1] + " " + words[i];
        }
        System.out.println(words[0]);
    }

    public static void main(String[] args) {
        String sentence = "getting.good/at?coding needs-a.lot.of.practice";
        reverse(sentence.split("[^a-zA-Z0-9_-]"));
    }
}
