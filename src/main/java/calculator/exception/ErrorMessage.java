package calculator.exception;

public enum ErrorMessage {
    INVALID_CUSTOM_DELIMITER("커스텀 구분자로 숫자를 올바르게 구분해야 합니다."),
    INVALID_DEFAULT_EXPRESSION("유효하지 않은 계산식 형식입니다."),
    NULL_INPUT("입력값은 null일 수 없습니다."),
    NEGATIVE_NUMBER("음수는 허용되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
