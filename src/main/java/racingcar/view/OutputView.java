package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String Symbol = "-";

    public static void printResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            String name = car.getName();
            String dashes = convertSymbol(car.getPosition());

            System.out.println(name + " : " + dashes);
        }
        System.out.println();
    }

    private static String convertSymbol(int position) {
        return Symbol.repeat(position);
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
