package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.StringCalculator;
import calculator.exception.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest extends NsTest {

    @Test
    @DisplayName("빈 문자열 입력 시 0을 반환한다.")
    void emptyStringReturnsZero() {
        int result = StringCalculator.calculate("");
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("null 입력 시 IllegalArgumentException 발생")
    void nullInputThrowsException() {
        assertThatThrownBy(() -> StringCalculator.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NULL_INPUT.getMessage());
    }

    @Test
    @DisplayName("기본 구분자(, :) 사용 시 정상 합산")
    void defaultDelimiterSum() {
        int result = StringCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(;) 사용 시 정상 합산")
    void customDelimiterSum() {
        int result = StringCalculator.calculate("//;\\n4;5;6");
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("커스텀 구분자와 잘못된 문자 혼용 시 예외 발생")
    void invalidCustomDelimiterMix() {
        assertThatThrownBy(() -> StringCalculator.calculate("//;\\n1;7,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER.getMessage());
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
