package pl.laptopy.polizingowe.errors;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException(ErrorCode message) {
        super(String.valueOf(message));
    }
}
