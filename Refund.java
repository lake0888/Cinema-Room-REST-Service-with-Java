package cinema;

public class Refund {
    private Seat ticket;

    public Refund(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
