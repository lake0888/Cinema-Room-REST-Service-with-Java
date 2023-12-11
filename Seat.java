package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Objects;

public class Seat {

    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean purchased;

    public Seat() {
        this(0, 0);
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.price = (this.row <= 4) ? 10 : 8;
        this.purchased = false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && column == seat.column && price == seat.price && purchased == seat.purchased;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, price, purchased);
    }

    @Override
    public String toString() {
        return "{" +
                "   row:" + row +
                ",  column:" + column +
                ",  price:" + price +
                "   }";
    }
}
