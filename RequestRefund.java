package cinema;

import java.util.UUID;

public class RequestRefund {
    private String token;

    public RequestRefund() {
        this.token = "";
    }

    public RequestRefund(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RequestRefund{" +
                "token='" + token + '\'' +
                '}';
    }
}
