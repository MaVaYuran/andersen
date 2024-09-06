package homework2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ticket extends BaseID implements Printable {
    private int id;
    private String concertHall;
    private int eventCode;
    private String time;

    private boolean isPromo;
    private Sector sector;
    private float maxWeight;

    private double price;

    public Ticket() {
    }

    public Ticket(String concertHall, int eventCode) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = getTime();
    }

    public Ticket(int id, String concertHall, int eventCode, boolean isPromo,
                  Sector sector, Float maxWeight, double price) {
        this.id = id;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = getTime();
        this.isPromo = isPromo;
        this.sector = sector;
        this.maxWeight = maxWeight;
        this.price = price;
    }

    private String getTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        String dateTime = dtf.format(LocalDateTime.now());
        return dateTime;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
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

    public static void shared(String receiver, Ticket ticket) {
        System.out.println("Ticket shared via " + receiver + ":  " + ticket);
    }

    @Override
    public String toString() {
        return "Ticket{" +
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
