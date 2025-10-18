package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class Numbers {
    private final List<PositiveNumber> values;

    private Numbers(List<PositiveNumber> values) {
        this.values = values;
    }

    public static Numbers from(String[] tokens) {
        List<PositiveNumber> numbers = Arrays.stream(tokens)
                .map(Integer::parseInt)
                .map(PositiveNumber::of)
                .toList();
        return new Numbers(numbers);
    }

    public int sum() {
        return values.stream()
                .mapToInt(PositiveNumber::getValue)
                .sum();
    }
}
