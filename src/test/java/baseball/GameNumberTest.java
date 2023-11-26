package baseball;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameNumberTest {

    @DisplayName("세 자리수가 아니면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12"})
    void validateRange(String number) {
        Assertions.assertThatThrownBy(() -> GameNumberFactory.createNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자에 0이 포함되면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"104", "012"})
    void validateContainZero(String number) {
        Assertions.assertThatThrownBy(() -> GameNumberFactory.createNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"114", "911", "355"})
    void validateDuplicate(String number) {
        Assertions.assertThatThrownBy(() -> GameNumberFactory.createNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 숫자가 아니면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1 3 5", "일이삼", "-135"})
    void validateNumber(String number) {
        Assertions.assertThatThrownBy(() -> GameNumberFactory.createNumbers(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼 개수 구하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123,0", "389,1", "321,2", "312,3", "754,0"})
    void calculateBallCount(String number, int ballCount) {
        GameNumber gameNumber1 = GameNumberFactory.createNumbers("123");
        GameNumber gameNumber2 = GameNumberFactory.createNumbers(number);

        int actual = gameNumber1.calculateBallCount(gameNumber2);
        int expected = ballCount;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("스트라이크 개수 구하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"123,3", "389,0", "321,1", "312,0", "423,2"})
    void calculateStrikeCount(String number, int strikeCount) {
        GameNumber gameNumber1 = GameNumberFactory.createNumbers("123");
        GameNumber gameNumber2 = GameNumberFactory.createNumbers(number);

        int actual = gameNumber1.calculateStrikeCount(gameNumber2);
        int expected = strikeCount;

        Assertions.assertThat(actual).isEqualTo(expected);
    }

}
