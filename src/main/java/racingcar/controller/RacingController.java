package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors; // 1. 이 임포트를 추가하세요!

public class RacingController {

    public void start() {
        String namesInput = InputView.readCarNames();

        // 2. .toList()를 .collect(Collectors.toList())로 바꿉니다.
        List<String> carNames = Arrays.stream(namesInput.split(",", -1))
                .collect(Collectors.toList());

        for (String name : carNames) {
            if (name.contains(" ")) {
                throw new IllegalArgumentException("[ERROR] 이름에 공백을 포함할 수 없습니다.");
            }
            // 3. 빈 문자열(,,) 체크도 안전하게 추가합니다.
            if (name.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 이름은 빈 값일 수 없습니다.");
            }
        }

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