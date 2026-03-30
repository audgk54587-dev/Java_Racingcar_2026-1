package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<String> name) {
        this.cars = createCars(name);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        for(int i=0;i<names.size();i++) {
            Car car = new Car(names.get(i));
            carList.add(car);
        }
        return carList;
    }

    public void playRound() {
        for (int i=0; i<cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);

            Car car = cars.get(i);
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;
        for(int i=0;i<cars.size();i++) {
            if(cars.get(i).getPosition() > maxPosition) {
                maxPosition = cars.get(i).getPosition();
            }
        }
        List<String> winners = new ArrayList<>();
        for(int i=0;i<cars.size();i++) {
            if(cars.get(i).getPosition() == maxPosition) {
                winners.add(cars.get(i).getName());
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
