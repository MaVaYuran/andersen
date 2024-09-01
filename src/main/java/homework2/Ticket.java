package homework2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Ticket {
    private String ID;
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

    public Ticket(String concertHall, int eventCode, boolean isPromo,
                  Sector sector, Float maxWeight, double price) {
        this.ID = generateID();
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



    static String generateID() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int randomChar = random.nextInt(36);

            if (randomChar < 10) {
                sb.append((char) ('0' + randomChar));
            } else {
                sb.append((char) ('A' + randomChar - 10));
            }
        }
        return sb.toString();
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "ID = '" + ID + '\'' +
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
