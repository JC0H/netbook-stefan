package pl.laptopy.polizingowe.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiException e){
        HttpStatus badRequest = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiExceptionResponse, badRequest);
    }
}
