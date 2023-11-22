package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameNumber {
    private final List<Integer> gameNumbers;

    public GameNumber(String number) {
        GameNumberValidator.validate(number);

        this.gameNumbers = Stream.of(number)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
