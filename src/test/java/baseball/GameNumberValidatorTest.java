package baseball;

import baseball.domain.GameNumberValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameNumberValidatorTest {

    @DisplayName("입력의 크기가 3이 아니면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"12", " 123", "1234", "1,2,3", "", " ", "123 "})
    void validateSize(String invalidInput) {
        Assertions.assertThatThrownBy(() -> GameNumberValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 외에 입력은 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 2", " a13", "일이삼", " 1 2 3"})
    void validateNumber(String invalidInput) {
        Assertions.assertThatThrownBy(() -> GameNumberValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
