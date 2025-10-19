package calculator.util;

import calculator.exception.ErrorMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionValidator {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final Pattern DEFAULT_PATTERN = Pattern.compile("^-?[0-9]+([,:]-?[0-9]+)*$");

    public static void validate(String expression) {
        if (isCustomExpression(expression)) {
            validateCustomExpression(expression);
            return;
        }
        validateDefaultExpression(expression);
    }

    private static boolean isCustomExpression(String expression) {
        return CUSTOM_PATTERN.matcher(expression).matches();
    }

    private static void validateCustomExpression(String expression) {
        Matcher matcher = CUSTOM_PATTERN.matcher(expression);
        matcher.matches();

        String delimiter = matcher.group(1);
        String numbers = matcher.group(2);

        String escapedDelimiter = Pattern.quote(delimiter);
        String validCustomFormat = "^-?[0-9]+(" + escapedDelimiter + "-?[0-9]+)*$";

        if (!Pattern.matches(validCustomFormat, numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CUSTOM_DELIMITER.getMessage());
        }
    }

    private static void validateDefaultExpression(String expression) {
        if (!DEFAULT_PATTERN.matcher(expression).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DEFAULT_EXPRESSION.getMessage());
        }
    }
}
