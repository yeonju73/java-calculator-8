package calculator.domain;

public class ExpressionSplitter {
    private static final String DEFAULT_DELIMITERS = ",|:";

    public String[] split(String expression) {
        return expression.split(DEFAULT_DELIMITERS);
    }
}
