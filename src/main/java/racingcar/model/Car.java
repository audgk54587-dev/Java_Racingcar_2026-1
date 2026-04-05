package racingcar.model;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position=0;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int num){
        if (num >= MOVE_THRESHOLD) {
            position += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
