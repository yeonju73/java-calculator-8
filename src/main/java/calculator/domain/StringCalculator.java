package calculator.domain;

public class StringCalculator {
    public int calculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        ExpressionSplitter expressionSplitter = new ExpressionSplitter();
        String[] tokens = expressionSplitter.split(expression);
        Numbers numbers = Numbers.from(tokens);

        return numbers.sum();
    }
}
