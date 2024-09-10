package homework4;


import java.time.LocalDateTime;
import java.util.Objects;

public class BusTicket {
    private TicketClass ticketClass;
    private TicketType ticketType;
    private LocalDateTime startDate;
    private int pprice;

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public int getPprice() {
        return pprice;
    }

    public BusTicket() {
    }

    public BusTicket(TicketClass ticketClass, TicketType ticketType, LocalDateTime startDate, int pprice) {
        this.ticketClass = ticketClass;
        this.ticketType = ticketType;
        this.startDate = startDate;
        this.pprice = pprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusTicket busTicket = (BusTicket) o;

        if (pprice != busTicket.pprice) return false;
        if (ticketClass != busTicket.ticketClass) return false;
        if (ticketType != busTicket.ticketType) return false;
        return Objects.equals(startDate, busTicket.startDate);
    }

    @Override
    public int hashCode() {
        int result = ticketClass != null ? ticketClass.hashCode() : 0;
        result = 31 * result + (ticketType != null ? ticketType.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + pprice;
        return result;
    }

    @Override
    public String toString() {
        return "BusTicket{" +
               "ticketClass=" + ticketClass +
               ", ticketType=" + ticketType +
               ", startDate=" + startDate +
               ", pprice=" + pprice +
               '}';
    }
}
