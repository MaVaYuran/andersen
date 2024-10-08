package by.mariayuran.homework;

import by.mariayuran.homework.annotation.NullableValidator;
import by.mariayuran.homework.annotation.NullableWarning;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Objects;


public class ConcertTicket extends BaseID implements Printable {
    @NullableWarning
    private String concertHall;
    private int eventCode;

    private String time;
    private boolean isPromo;
    private Sector sector;
    private float maxWeight;

    private double price;


    public ConcertTicket() {
        super(0);
        NullableValidator.checkForNull(this);
    }

    public ConcertTicket(int id, String concertHall, int eventCode, boolean isPromo,
                  Sector sector, Float maxWeight, double price) {
        super(id);
        this.concertHall = concertHall;
        NullableValidator.checkForNull(this);
        this.eventCode = eventCode;
        this.time = getTime();
        this.isPromo = isPromo;
        this.sector = sector;
        this.maxWeight = maxWeight;
        this.price = price;
    }


    public Sector getSector() {
        return sector;
    }

    public double getPrice() {
        return price;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    private String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
        String dateTime = dtf.format(LocalDateTime.now());
        return dateTime;
    }

    public void shared(String phoneNumber) {
        System.out.println("ConcertTicket #" + this.id + " was shared by phone " + phoneNumber);
    }


    public void shared(String phoneNumber, String email) {
        System.out.println("ConcertTicket #" + this.id + " was shared by phone " + phoneNumber + " and email " + email);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConcertTicket ticket = (ConcertTicket) o;

        if (id != ticket.id) return false;
        if (eventCode != ticket.eventCode) return false;
        if (isPromo != ticket.isPromo) return false;
        if (Float.compare(ticket.maxWeight, maxWeight) != 0) return false;
        if (Double.compare(ticket.price, price) != 0) return false;
        if (!Objects.equals(concertHall, ticket.concertHall)) return false;
        if (!Objects.equals(time, ticket.time)) return false;
        return sector == ticket.sector;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (concertHall != null ? concertHall.hashCode() : 0);
        result = 31 * result + eventCode;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isPromo ? 1 : 0);
        result = 31 * result + (sector != null ? sector.hashCode() : 0);
        result = 31 * result + (maxWeight != +0.0f ? Float.floatToIntBits(maxWeight) : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ConcertTicket{" +
               "ID = '" + id + '\'' +
               ", concertHall = '" + concertHall + '\'' +
               ", eventCode = " + eventCode +
               ", time = '" + time + '\'' +
               ", isPromo = " + isPromo +
               ", sector = " + sector +
               ", maxWeight = " + maxWeight +
               ", price = " + price +
               '}';
    }
}
