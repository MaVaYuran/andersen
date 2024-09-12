package homework4;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;
@JsonAutoDetect
public class BusTicket {
    private TicketClass ticketClass;
    private String ticketType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime startDate;
    private int ticketPrice;

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BusTicket() {
    }

//    public BusTicket(TicketClass ticketClass, String ticketType, LocalDateTime startDate, int ticketPrice) {
//        this.ticketClass = ticketClass;
//        this.ticketType = ticketType;
//        this.startDate = startDate;
//        this.ticketPrice = ticketPrice;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusTicket busTicket = (BusTicket) o;

        if (ticketPrice != busTicket.ticketPrice) return false;
        if (ticketClass != busTicket.ticketClass) return false;
        if (!Objects.equals(ticketType, busTicket.ticketType)) return false;
        return Objects.equals(startDate, busTicket.startDate);
    }

    @Override
    public int hashCode() {
        int result = ticketClass != null ? ticketClass.hashCode() : 0;
        result = 31 * result + (ticketType != null ? ticketType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + ticketPrice;
        return result;
    }

    @Override
    public String toString() {
        return "BusTicket{" +
               "ticketClass=" + ticketClass +
               ", ticketType=" + ticketType +
               ", startDate=" + startDate +
               ", ticketPrice=" + ticketPrice +
               '}';
    }
}
