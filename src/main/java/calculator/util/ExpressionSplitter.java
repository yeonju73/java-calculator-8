package calculator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionSplitter {
    private static final String DEFAULT_DELIMITERS = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    public String[] split(String expression) {
        // 커스텀 구분자 패턴에 해당하는지 검사
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);

        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITERS);
    }
}
