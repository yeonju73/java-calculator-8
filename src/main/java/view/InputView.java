package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public static String readExpression() {
        System.out.println(INPUT_PROMPT_MESSAGE);
        return Console.readLine();
    }
}
