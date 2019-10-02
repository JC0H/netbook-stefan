package pl.laptopy.polizingowe.errors;

public class ApiException extends RuntimeException {

    public ApiException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
