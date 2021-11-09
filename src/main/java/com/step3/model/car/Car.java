package com.step3.model.car;

public class Car {
    private CarId id;
    private CarPosition position;

    public Car(CarId id, CarPosition position) {
        this.id = id;
        this.position = position;
    }

    public Car move(boolean isMoved) {
        this.position = position.add(isMoved);
        return this;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;
        return id.getId() == car.id.getId();
    }
}