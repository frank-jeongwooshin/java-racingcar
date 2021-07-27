package calculator;

import calculator.exception.DivideByZeroException;
import calculator.exception.InvalidFormulaException;
import calculator.exception.InvalidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 계산기")
class StringCalculatorTest {

	private final StringCalculator calculator = new StringCalculator();

	@DisplayName("더하기 연산을 수행한다.")
	@Test
	void add() {
		assertThat(calculator.calculate("2 + 5")).isEqualTo(7);
	}

	@DisplayName("빼기 연산을 수행한다.")
	@Test
	void subtract() {
		assertThat(calculator.calculate("5 - 2")).isEqualTo(3);
	}

	@DisplayName("곱하기 연산을 수행한다.")
	@Test
	void multiply() {
		assertThat(calculator.calculate("2 * 5")).isEqualTo(10);
	}

	@DisplayName("나누기 연산을 수행한다.")
	@Test
	void divide() {
		assertThat(calculator.calculate("10 / 2")).isEqualTo(5);
	}

	@DisplayName("사칙연산을 모두 포함하는 연산을 수행한다.")
	@Test
	void calculateWithAllOperators() {
		assertThat(calculator.calculate("2 + 3 - 1 * 5 / 2")).isEqualTo(10);
	}

	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 예외가 발생한다.")
	@ParameterizedTest(name = "입력 값이 {0}인 경우")
	@NullAndEmptySource
	void invalidInputText(String inputText) {
		assertThatThrownBy(() -> calculator.calculate(inputText))
			.isInstanceOf(InvalidFormulaException.class);
	}

	@DisplayName("0으로 나누려고 할 경우 예외가 발생한다.")
	@Test
	void divideByZero() {
		assertThatThrownBy(() -> calculator.calculate("2 / 0"))
			.isInstanceOf(DivideByZeroException.class);
	}

	@DisplayName("유효한 연산자가 아닐 경우 예외가 발생한다.")
	@Test
	void invalidOperator() {
		assertThatThrownBy(() -> calculator.calculate("2 ^ 5"))
			.isInstanceOf(InvalidOperatorException.class);
	}

}