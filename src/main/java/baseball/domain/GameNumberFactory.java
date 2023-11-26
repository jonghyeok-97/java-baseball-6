package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameNumberFactory {

    public static GameNumber createRandomNumbers() {
        return GameNumber.from(generateRandomNumbers());
    }

    public static GameNumber createNumbers(String input) {
        validate(input);
        return GameNumber.from(generateNumbers(input));
    }

    private static List<Number> generateRandomNumbers() {
        return IntStream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .mapToObj(Number::from)
                .collect(Collectors.toList());
    }

    private static void validate(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Number> generateNumbers(String inputNumber) {
        return Stream.of(inputNumber.split(""))
                .map(Integer::parseInt)
                .map(Number::from)
                .collect(Collectors.toList());
    }
}
