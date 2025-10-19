package calculator;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String expression = InputView.readExpression();
        int result = StringCalculator.calculate(expression);
        OutputView.printResult(result);
    }
}
