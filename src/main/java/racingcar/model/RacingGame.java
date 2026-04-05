package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<String> name) {
        this.cars = createCars(name);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name));
        }
        return carList;
    }

    public void playRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
        //원본주소를 직접 반환하면 외부에서 수정 가능 -> 수정: 원본주소를 수정 불가능한 상태로 바꿔서 반환
        //Collections: java.util 패키지에 포함된 유틸리티 클래스, 위에서 임포트
        //.unmodifiableList(): 수정 불가능한 상태로 감싸서 반환
    }
}
