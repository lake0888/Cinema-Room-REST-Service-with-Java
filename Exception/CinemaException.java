package cinema.Exception;

import org.springframework.http.HttpStatus;

public class CinemaException extends RuntimeException {

    private HttpStatus status;
    public CinemaException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
