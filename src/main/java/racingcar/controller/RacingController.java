package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
public class RacingController {

    public void start() {
        String namesInput = InputView.readCarNames();
        List<String> carNames = Arrays.stream(namesInput.split(","))
                .map(String::trim)
                .toList();
        if (new java.util.HashSet<>(carNames).size() != carNames.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 있습니다.");
        }
        RacingGame racingGame = new RacingGame(carNames);

        int tryCount = InputView.readTryCount();

        OutputView.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }

        List<String> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}