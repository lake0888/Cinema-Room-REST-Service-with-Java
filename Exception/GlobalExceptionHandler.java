package cinema.Exception;

import cinema.Exception.CinemaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CinemaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionResponse> handleCinemaException(CinemaException ex) {
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage()), ex.getStatus());
    }
}
