package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Car;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step3.GameRule.decideMove;
import static step5.domain.CarFactory.produceCar;
import static step5.domain.Winner.getWinner;


class RacingCarTest {

    @Test
    void move_forward_차가_전진했을_경우() {
        assertThat(decideMove(4)).isEqualTo(1);
    }

    @Test
    void move_stop_차가_그대로일_경우() {
        assertThat(decideMove(3)).isEqualTo(0);
    }

    @Test
    void input_이름만큼_차_생산() {
        assertThat(produceCar(new String[]{"pobi","crong","honux"}).size()).isEqualTo(3);
    }

    @Test
    void input_이름_알맞게_저장확인() {
        assertThat(produceCar(new String[]{"pobi","crong","honux"}).get(0).name).isEqualTo("pobi");
    }

    @Test
    void input_이름이_5글자_넘어가면_에러() {
        assertThatThrownBy(() -> {
            produceCar(new String[]{"pobi","crong","honux","yeonsu"});
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void winner_구하기() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi", 5));
        carList.add(new Car("crong", 3));
        carList.add(new Car("honux", 2));
        assertThat(getWinner(carList).size()).isEqualTo(1);
        assertThat(getWinner(carList).get(0).name).isEqualTo("pobi");
    }

    @Test
    void winner_2명일_때() {
        Car pobi = new Car("pobi", 5);
        Car crong = new Car("crong", 5);
        Car honux = new Car("honux", 2);
        List<Car> carList = List.of(pobi,crong,honux);

        assertThat(getWinner(carList).size()).isEqualTo(2);
        assertThat(getWinner(carList)).isEqualTo(List.of(pobi,crong));
    }
}