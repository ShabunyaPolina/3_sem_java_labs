package by.bsu.shabunya.lab9.exception;

public class ReaderException extends Exception{

    public ReaderException() {}

    public ReaderException(String  message) {
        super(message);
    }

    public ReaderException(Throwable cause) {
        super(cause);
    }
}
