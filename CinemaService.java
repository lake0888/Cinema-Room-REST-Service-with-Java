package cinema;

import cinema.Exception.CinemaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CinemaService {
    public Cinema cinema;

    @Autowired
    public CinemaService() {
        this.cinema = new Cinema(9, 9);
    }

    public Cinema findAll() {
        return cinema;
    }

    public Seat findByRowColumn(int row, int column) {
        if (row > 0 && row <= cinema.getRows() && column > 0 && column <= cinema.getColumns()) {
            return cinema.getSeats().get((cinema.getRows() * (row - 1)) + column - 1);
        } else {
            throw new CinemaException("The number of a row or a column is out of bounds!", HttpStatus.BAD_REQUEST);
        }
    }

    public Purchase save(Seat newSeat) {
        Seat seat = findByRowColumn(newSeat.getRow(), newSeat.getColumn());
        if (seat.isPurchased()) {
            throw  new CinemaException("The ticket has been already purchased!", HttpStatus.BAD_REQUEST);
        } else {
            seat.setPurchased(true);
            Purchase purchase = new Purchase(UUID.randomUUID(), seat);
            cinema.getPurchaseList().add(purchase);
            return purchase;
        }
    }

    public Refund refund(RequestRefund requestRefund) {
        boolean flag = true;
        String strToken = requestRefund.getToken();
        if (strToken.length() == 36) {
            UUID token = UUID.fromString(strToken);
            int index = findTicket(token);
            if (index != -1) {
                Purchase purchase = cinema.getPurchaseList().get(index);
                purchase.getTicket().setPurchased(false);
                cinema.getPurchaseList().remove(purchase);
                return new Refund(purchase.getTicket());
            } else {
                flag = false;
            }
        } else {
            flag = false;
        }

        if (!flag) {
            throw new CinemaException("Wrong token!", HttpStatus.BAD_REQUEST);
        }
        return new Refund(new Seat());
    }

    private int findTicket(UUID token) {
        List<Purchase> purchaseList = cinema.getPurchaseList();
        for (int i = 0; i < purchaseList.size(); i++) {
            Purchase purchase = purchaseList.get(i);
            if (purchase.getToken().equals(token))
                return i;
        }
        return -1;
    }

    public Stats showStats(String password) {
        if (password == null || !password.equals("super_secret"))
            throw new CinemaException("The password is wrong!", HttpStatus.UNAUTHORIZED);
        return new Stats(cinema.income(), cinema.available(), cinema.purchased());
    }
}
