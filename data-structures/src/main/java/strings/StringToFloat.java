/*
package strings;

public class StringToFloat {

    private static float convert(final String num) throws InvalidFormatExceptionCustom {
        if (num == null || num.length() == 0) throw new InvalidFormatExceptionCustom() ;

        if (num.matches(^[0-9].)) { // regex to check if the input is valid
            final int indexOfDecimal = num.indexOf(".");
            float finalNumber;
            int multiplier = 1;
            boolean isNegative;
            for (int i = indexOfDecimal-1; i>=0; i--) {
                if (!num.charAt(i) == '-') {
                    int number = Character.getNumericValue(num.charAt(i)) * multiplier;
                    finalNumber += number;
                    multiplier *= 10;
                } else {
                    isNegative = true;
                }
            }

            float divisor = 10;
            for (int i=indexOfDecimal+1; i<num.length(); i++) {
                float number = Character.getNumericValue(num.charAt(i)) / divisor;
                finalNumber += num;
                divisor *= 10;
            }
            if (isNegative) {
                finalNumber = 0.0 - finalNumber;
            }
            return finalNumber;
        } else {
            throw new InvalidFormatExceptionCustom();
        }

    }

//23.145

}
*/
