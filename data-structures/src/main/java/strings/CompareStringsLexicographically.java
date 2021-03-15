package strings;

public class CompareStringsLexicographically {

    private static void getSmallestAndLargest(String s, int k) {
        String currString = s.substring(0, k);
        String minLenString = currString;
        String maxLenString = currString;

        for (int i = k; i<s.length(); i++) {
            currString = currString.substring(1, k) + s.charAt(i);
            if (minLenString.compareTo(currString) > 0) minLenString = currString;
            if (maxLenString.compareTo(currString) < 0) maxLenString = currString;
        }

        System.out.println("Smallest Lexicographic Substring : " + minLenString);
        System.out.println("Largest Lexicographic Substring : " + maxLenString);
    }

    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        int k = 3;
        getSmallestAndLargest(str, k);
    }
}
