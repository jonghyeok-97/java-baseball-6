package baseball.domain;

public class GameNumberValidator {

    public static void validate(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException("입력은 3개만 가능합니다.");
        }
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }


    }
}
