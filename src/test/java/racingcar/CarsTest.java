package racingcar;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class CarsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static Cars cars;

    @BeforeEach
    void 자동차_테스트_초기_설정() {
        cars = new Cars(Arrays.asList(
                new Car("Audi"), new Car("Benz"), new Car("Ford"), new Car("Volvo")));
    }

    @Test
    void 자동차_출력_테스트() {
        Assertions.assertThat(cars.race(0).toString())
                .contains("Audi : \nBenz : \nFord : \nVolvo : ");
    }

    @Test
    void 자동차_1회경주_후_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(cars.race(1).toString())
                            .contains("Audi : -\nBenz : \nFord : -\nVolvo : -");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_2회경주_후_출력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(cars.race(2).toString())
                            .contains("Audi : -\nBenz : --\nFord : -\nVolvo : ");
                },
                MOVING_FORWARD, STOP,               //Audi
                MOVING_FORWARD, MOVING_FORWARD,     //Benz
                STOP, MOVING_FORWARD,               //Ford
                STOP, STOP                          //Volvo
        );
    }

    @Test
    void 단독_우승_테스트() {

        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat((cars.race(2).getWinner()
                            .contains("Benz"))).isTrue();
                },
                MOVING_FORWARD, STOP,               //Audi
                MOVING_FORWARD, MOVING_FORWARD,     //Benz
                STOP, MOVING_FORWARD,               //Ford
                STOP, STOP                          //Volvo
        );
    }


    @Test
    void 공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(cars.race(2).getWinner()
                            .containsAll(Arrays.asList("Audi","Benz"))).isTrue();
                },
                MOVING_FORWARD, MOVING_FORWARD,     //Audi
                MOVING_FORWARD, MOVING_FORWARD,     //Benz
                STOP, MOVING_FORWARD,               //Ford
                STOP, STOP                          //Volvo
        );
    }


    @Test
    void 멈춤_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(cars.race(2).getWinner()
                            .containsAll(Arrays.asList("Audi","Benz","Ford","Volvo"))).isTrue();
                },
                STOP, STOP,     //Audi
                STOP, STOP,     //Benz
                STOP, STOP,     //Ford
                STOP, STOP      //Volvo
        );
    }


    @Test
    void 한번_공동_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Assertions.assertThat(cars.race(1).getWinner()
                            .containsAll(Arrays.asList("Audi","Benz","Ford","Volvo"))).isTrue();
                },
                MOVING_FORWARD,     //Audi
                MOVING_FORWARD,     //Benz
                MOVING_FORWARD,     //Ford
                MOVING_FORWARD      //Volvo
        );
    }
}
