package baseball;

import baseball.domain.GameNumber;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameNumberTest {

    @DisplayName("세 자리수가 아니면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12"})
    void validateRange(String number) {
        List<Integer> numbers = Stream.of(number.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Assertions.assertThatThrownBy(() -> new GameNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);


    }
}
