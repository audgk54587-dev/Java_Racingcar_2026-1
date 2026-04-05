package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.HashSet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

    public void start() {
        String namesInput = InputView.readCarNames();

        List<String> carNames = Arrays.stream(namesInput.split(",", -1))
                .collect(Collectors.toList());

        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 이름에 공백을 포함할 수 없습니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 이름은 빈 값일 수 없습니다.");
            }
        }

        if (new HashSet<>(carNames).size() != carNames.size()) { //위에 import로 HashSet을 가져옴
            //HashSet 특징: 중복된 값을 허용하지 않음
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