package homework2;

import java.util.Date;
import java.util.Random;

public class Ticket {
    private String ID;
    private String concertHall;
    private int eventCode;
    private Date time;

    private boolean isPromo;
    private Sector sector;
    private float maxWeight;

    public Ticket() {
    }

    public Ticket(String concertHall) {
        this.concertHall = concertHall;
        this.eventCode = generateEventCode();
        this.time = getUnixTime();
    }

    public Ticket(String concertHall, boolean isPromo,
                  Sector sector, Float maxWeight) {
        this.ID = generateID();
        this.concertHall = concertHall;
        this.eventCode = generateEventCode();
        this.time = getUnixTime();
        this.isPromo = isPromo;
        this.sector = sector;
        this.maxWeight = maxWeight;
    }

    private Date getUnixTime() {
        Date time = new Date();
        return time;
    }

    private int generateEventCode() {
        Random random = new Random();
        int code = random.nextInt(900) + 100;
        return code;
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
               "ID='" + ID + '\'' +
               ", concertHall='" + concertHall + '\'' +
               ", eventCode=" + eventCode +
               ", time=" + time +
               ", isPromo=" + isPromo +
               ", sector=" + sector +
               ", maxWeight=" + maxWeight +
               '}';
    }
}
