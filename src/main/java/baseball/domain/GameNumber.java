package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameNumber {
    private final List<Integer> gameNumbers;

    public GameNumber(String number) {
        GameNumberValidator.validate(number);

        this.gameNumbers = number.chars()
                .boxed()
                .collect(Collectors.toList());
    }
}
