package strings;

public class EncryptionDecryption {

    private static String secureChannel(int operation, String message, String key) {
        if (message == null || message.isEmpty()) return "-1";
        if (key == null || key.isEmpty()) return "-1";
        switch (operation) {
            case 1:
                return encodeString(message, key);
            case 2:
                return decodeString(message, key);
            default:
                return "-1";
        }
    }

    private static String encodeString(String message, String key) {
        final StringBuilder encodedMessage = new StringBuilder();
        if (!key.matches("[1-9]+")) return "-1";
        for (int index = 0; index < message.length(); index++) {
            char letter = message.charAt(index);
            if (index < key.length()) {
                int keyNumeric = Character.getNumericValue(key.charAt(index));
                while (keyNumeric != 0) {
                    encodedMessage.append(letter);
                    keyNumeric--;
                }
            } else {
                encodedMessage.append(message.substring(index));
                break;
            }
        }
        return encodedMessage.toString();
    }

    private static String decodeString(String message, String key) {
        final StringBuilder decodedMessage = new StringBuilder();
        if (!key.matches("[1-9]+")) return "-1";
        int keyIndex = 0;
        int messageIndex = 0;
        int position = 0;
        while (keyIndex < key.length() && messageIndex < message.length()) {
            int keyNumeric = Character.getNumericValue(key.charAt(keyIndex));
            position += keyNumeric;
            if ((position - 1) >= message.length()) break;
            char letter = message.charAt(position - 1);
            decodedMessage.append(letter);
            keyIndex++;
            messageIndex = position;
        }
        if (messageIndex < message.length() && keyIndex < key.length())
            return "-1";
        if (messageIndex < message.length()) {
            decodedMessage.append(message.substring(messageIndex));
        }
        return decodedMessage.toString();
    }

    public static void main(String[] args) {
        System.out.println(secureChannel(1, "OPEN", "123"));
        System.out.println(secureChannel(2, "OPPEEEN", "123"));
    }
}
