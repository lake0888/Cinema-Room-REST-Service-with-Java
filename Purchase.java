package cinema;

import cinema.Seat;

import java.util.Objects;
import java.util.UUID;

public class Purchase {
    private UUID token;
    private Seat ticket;

    public Purchase(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(token, purchase.token) && Objects.equals(ticket, purchase.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, ticket);
    }
}
