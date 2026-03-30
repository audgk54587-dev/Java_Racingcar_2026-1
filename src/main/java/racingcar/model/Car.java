package racingcar.model;

public class Car {
    private final String name;
    private int position=0;

    public Car(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int num){
        if(num>=4) {
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
