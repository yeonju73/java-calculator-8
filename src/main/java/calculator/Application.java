package calculator;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        String expression = InputView.readExpression();
        String result = "출력 예시";
        OutputView.printResult(result);
    }
}
