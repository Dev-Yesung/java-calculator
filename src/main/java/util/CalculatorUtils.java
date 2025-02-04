package util;

public class CalculatorUtils {
    private CalculatorUtils() {
    }

    public static int parseStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 수로 변환할 수 없는 문자열이 입력됐습니다.");
        }
    }

    public static boolean isStringNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDigitCharacter(char input) {
        return Character.isDigit(input);
    }
}
