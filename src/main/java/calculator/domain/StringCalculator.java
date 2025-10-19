package calculator.domain;

import calculator.util.ExpressionSplitter;
import calculator.util.ExpressionValidator;

public class StringCalculator {
    public int calculate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }

        expression = expression.trim();
        if (expression.isEmpty()) {
            return 0; // 빈 문자열 처리
        }

        ExpressionValidator.validate(expression);

        ExpressionSplitter expressionSplitter = new ExpressionSplitter();
        String[] tokens = expressionSplitter.split(expression);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }
}
