package calculator.domain;

import calculator.util.ExpressionSplitter;
import calculator.util.ExpressionValidator;

public class StringCalculator {
    public int calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        ExpressionValidator.validate(expression);

        ExpressionSplitter expressionSplitter = new ExpressionSplitter();
        String[] tokens = expressionSplitter.split(expression);

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
    }
}
