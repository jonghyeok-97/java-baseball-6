package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class GameNumber {
    private final List<Number> numbers;

    private GameNumber(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static GameNumber from(List<Number> numbers) {
        return new GameNumber(numbers);
    }

    public int calculateBallCount(GameNumber other) {
        return (int) IntStream.range(0, 3)
                .filter(index -> !this.extractNumber(index).isSame(other.extractNumber(index))
                        && isContain(other.extractNumber(index)))
                .count();
    }

    public int calculateStrikeCount(GameNumber other) {
        return (int) IntStream.range(0, 3)
                .filter(index -> this.extractNumber(index).isSame(other.extractNumber(index)))
                .count();
    }

    private Number extractNumber(int index) {
        return numbers.get(index);
    }

    private boolean isContain(Number otherNumber) {
        return this.numbers.stream()
                .anyMatch(number -> number.isSame(otherNumber));
    }

    private void validate(List<Number> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }

        int duplicate = (int) numbers.stream()
                .map(Number::getValue)
                .distinct()
                .count();
        if (duplicate != 3) {
            throw new IllegalArgumentException();
        }
    }
}
