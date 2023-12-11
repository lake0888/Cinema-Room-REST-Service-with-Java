package cinema.Exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ExceptionResponse {
    private String error;
    public ExceptionResponse(String message) {
        this.error = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "{" +
                "\t error: " + error + '\'' +
                '}';
    }
}
