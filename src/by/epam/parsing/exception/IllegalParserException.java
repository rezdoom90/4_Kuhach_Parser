package by.epam.parsing.exception;

public class IllegalParserException extends Exception {
    public IllegalParserException() {
    }

    public IllegalParserException(String message) {
        super(message);
    }

    public IllegalParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParserException(Throwable cause) {
        super(cause);
    }

    @Override
    public void printStackTrace() {
        System.err.println("Parser can not run!");
    }
}
