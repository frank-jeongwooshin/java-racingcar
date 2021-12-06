package newRacingCar.domain;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    Car(Name name) {
        this(name, new Position(0));
    }
    Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            position.move();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}