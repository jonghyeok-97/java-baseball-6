package baseball;

import baseball.domain.GameNumber;
import baseball.domain.GameNumberFactory;
import baseball.domain.GameStartOption;
import baseball.domain.Result;
import baseball.domain.ResultFactory;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        do {
            play();
        } while (!GameStartOption.RESTART.equals(GameStartOption.find(InputView.read())));
    }

    private static void play() {
        GameNumber computerNumber = GameNumberFactory.createRandomNumbers();

        while (true) {
            GameNumber userNumber = GameNumberFactory.createNumbers(InputView.read());
            Result result = ResultFactory.createResult(computerNumber, userNumber);

            OutputView.print(result);
            if (result.isAllStrike()) {
                break;
            }
        }
    }


}
