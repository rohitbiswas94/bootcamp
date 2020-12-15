package strings;

public class StringRotationOfEachOther {

    private static boolean isStringRotated(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
            return false;
        else
            return (str1.length() == str2.length() && str1.concat(str1).contains(str2));
    }

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "CDAB";
        System.out.println(isStringRotated(str1, str2));
    }
}
