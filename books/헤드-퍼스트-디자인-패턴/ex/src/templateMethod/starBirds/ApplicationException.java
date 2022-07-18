package templateMethod.starBirds;

@SuppressWarnings("serial")
public class ApplicationException extends RuntimeException {

    /**
     * 메시지를 담는다
     * @param message
     */
    public ApplicationException(String message) {
        super(message);
    }

    /**
     * 메시지와 상위에 발생된 예외를 담을 수 있게 구성
     * @param message
     * @param cause
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * ApplicationException을 상속 받아서
     * 커맨드가 없을 경우
     * 즉 사용자가 입력한 명령어를 찾을 수 없거나,
     * 또는 정의되지 명령어, 잘못된 명령어, 인수를 입력했을 때
     * 구체적인 예외의 형식을 지정할 수 있도록
     * 이렇게 만들어진 상쇄 클래스도 있다
     * UndefinedCommandActionException, InvalidCommandArgumentsException
     */
    public static class CommandNotFoundException extends ApplicationException {

        public CommandNotFoundException() {
            super("command not found.");
        }

    }

    public static class UndefinedCommandActionException extends ApplicationException {

        public UndefinedCommandActionException() {
            super("command action is undefined.");
        }

    }

    public static class InvalidCommandArgumentsException extends ApplicationException {

        public InvalidCommandArgumentsException() {
            super("input error, please try again!");
        }

        public InvalidCommandArgumentsException(String message) {
            super(message);
        }

        public InvalidCommandArgumentsException(Throwable cause) {
            super(String.format("%s: %s", cause.getClass().getSimpleName(), cause.getMessage()), cause);
        }

    }

}
