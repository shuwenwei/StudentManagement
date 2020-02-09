package sww.stuinfo.exception;

public class DeleteFailedException extends RuntimeException {

    private String exceptionMessage;

    public DeleteFailedException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
