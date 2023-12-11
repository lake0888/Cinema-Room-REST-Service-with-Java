package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;

public class Cinema {
    private int rows;
    private int columns;
    private List<Seat> seats;
    @JsonIgnore
    private List<Purchase> purchaseList;

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();
        this.purchaseList = new ArrayList<>();
        initCinema();
    }

    private void initCinema() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats.add(new Seat(i + 1, j + 1));
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return rows == cinema.rows && columns == cinema.columns && Objects.equals(seats, cinema.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, Objects.hash(seats));
    }

    @Override
    public String toString() {
        return "{" +
                "   rows:" + rows +
                ",  columns:" + columns +
                ",  seats: [" + seats +
                "   ]" +
                "}";
    }

    public int income() {
        int sum = 0;
        for (Purchase purchase : purchaseList) {
            sum += purchase.getTicket().getPrice();
        }
        return sum;
    }

    public int available() {
        return this.seats.size() - purchased();
    }

    public int purchased() {
        return this.purchaseList.size();
    }
}
