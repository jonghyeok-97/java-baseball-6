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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력은 3개만 가능합니다.");
    }

    @DisplayName("숫자 외에 입력은 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 2", "a13", "일이삼", "1 2"})
    void validateNumber(String invalidInput) {
        Assertions.assertThatThrownBy(() -> GameNumberValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력 가능합니다.");
    }

    @DisplayName("숫자에 0이 있으면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"102", " 013", "089", "560"})
    void validateZero(String invalidInput) {
        Assertions.assertThatThrownBy(() -> GameNumberValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 중 0 빼고 입력해주세요.");
    }

    @DisplayName("숫자가 중복되면 예외 발생하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"112", "313", "989", "555"})
    void validateDuplicate(String invalidInput) {
        Assertions.assertThatThrownBy(() -> GameNumberValidator.validate(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }
}
