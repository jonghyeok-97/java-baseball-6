package baseball.controller;

import baseball.domain.GameNumber;
import baseball.view.InputView;

public class Game {

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
        GameNumber userNumber = createGameNumber();


    }

    private GameNumber createGameNumber() {
        while (true) {
            try {
                return new GameNumber(InputView.read());
            } catch (IllegalArgumentException error) {
                System.out.println("다시 입력해 주세요.");
            }
        }
    }
}
