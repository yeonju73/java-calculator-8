package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import calculator.exception.ErrorMessage;
import calculator.util.ExpressionValidator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExpressionValidatorTest extends NsTest {

    @Test
    @DisplayName("기본 구분자(, :)로 이루어진 정상 입력은 통과한다.")
    void validDefaultExpression() {
        assertThatCode(() -> ExpressionValidator.validate("1,2:3"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기본 구분자가 아닌 문자가 포함되면 예외 발생")
    void invalidDefaultExpression() {
        assertThatThrownBy(() -> ExpressionValidator.validate("1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_DEFAULT_EXPRESSION.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자를 사용한 정상 입력은 통과한다.")
    void validCustomDelimiter() {
        assertThatCode(() -> ExpressionValidator.validate("//;\\n1;2;3"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("커스텀 구분자로 지정되지 않은 문자로 숫자를 구분하면 예외 발생")
    void invalidCustomDelimiter() {
        assertThatThrownBy(() -> ExpressionValidator.validate("//;\\n1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("음수가 포함된 입력도 정규식은 통과한다 (음수 검증은 domain에서 처리)")
    void allowNegativeForValidation() {
        assertThatCode(() -> ExpressionValidator.validate("1,-2,3"))
                .doesNotThrowAnyException();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
