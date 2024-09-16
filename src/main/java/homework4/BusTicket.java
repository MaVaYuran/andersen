package homework4;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;
@JsonAutoDetect
public class BusTicket {
    private TicketClass ticketClass;
    private String ticketType;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private Integer ticketPrice;

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public String getTicketType() {
        return ticketType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BusTicket() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusTicket ticket = (BusTicket) o;

        if (ticketPrice != ticket.ticketPrice) return false;
        if (ticketClass != ticket.ticketClass) return false;
        if (!Objects.equals(ticketType, ticket.ticketType)) return false;
        return Objects.equals(startDate, ticket.startDate);
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
