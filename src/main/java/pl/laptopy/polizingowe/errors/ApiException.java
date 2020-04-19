package pl.laptopy.polizingowe.errors;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime dateStamp;

    ApiException(String message, HttpStatus httpStatus, ZonedDateTime dateStamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateStamp = dateStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getDateStamp() {
        return dateStamp;
    }
}
