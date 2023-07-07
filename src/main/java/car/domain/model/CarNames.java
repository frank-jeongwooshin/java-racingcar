package car.domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private static final String REGEX_CAR_NAME = ",";
    private final List<CarName> carNames;

    public CarNames(final String userInputCarNames) {
        validateCarNames(userInputCarNames);
        this.carNames = Arrays.stream(userInputCarNames.split(REGEX_CAR_NAME))
            .map(CarName::new).collect(Collectors.toList());
    }

    private void validateCarNames(final String userInputCarNames) {
        if (userInputCarNames.isBlank()) {
            throw new RuntimeException("입력값이 없습니다.");
        }
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

}