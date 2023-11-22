package baseball.domain;

import java.util.stream.Stream;

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

        Stream.of(number)
                .filter(num -> num.contains("0"))
                .findAny()
                .ifPresent(num -> {
                    throw new IllegalArgumentException("숫자 중 0 빼고 입력해주세요.");
                });

        int count = (int) number.chars()
                .mapToObj(num -> (char) num)
                .distinct()
                .count();
        if (count != 3) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }
}
