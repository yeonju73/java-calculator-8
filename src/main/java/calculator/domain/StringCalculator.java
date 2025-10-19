package calculator.domain;

import calculator.exception.ErrorMessage;
import calculator.util.ExpressionSplitter;
import calculator.util.ExpressionValidator;

public class StringCalculator {
    public static int calculate(String expression) {
        handleNullInput(expression);
        if (expression.isEmpty()) {
            return 0;
        }

        ExpressionValidator.validate(expression);
        String[] tokens = ExpressionSplitter.split(expression);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }

    private static void handleNullInput(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT.getMessage());
        }
    }
}
