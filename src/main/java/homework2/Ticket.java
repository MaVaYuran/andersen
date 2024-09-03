package homework2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ticket {
    private String id;
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

    public Ticket(String id, String concertHall, int eventCode, boolean isPromo,
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

    public String getId() {
        return id;
    }

    public Sector getSector() {
        return sector;
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
