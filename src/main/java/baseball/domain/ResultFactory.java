package baseball.domain;

public class ResultFactory {

    public static Result createResult(GameNumber computerNumber, GameNumber userNumber) {
        int ballCount = computerNumber.calculateBallCount(userNumber);
        int strikeCount = computerNumber.calculateStrikeCount(userNumber);

        return Result.of(ballCount, strikeCount);
    }
}
