package baseball.domain;

import java.util.List;

public class GameNumber {
    private final List<Integer> numbers;

    public GameNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("세 자리 수여야 합니다.");
        }
        numbers.stream()
                .filter(number -> number == 0)
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException("숫자에 0이 포함될 수 없습니다.");
                });
    }

}
