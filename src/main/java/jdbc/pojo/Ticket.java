package jdbc.pojo;

import homework.TicketType;

import java.sql.Timestamp;
import java.util.Objects;

public class Ticket {
    private int id;
    private int userId;
    private TicketType ticketType;
    private Timestamp creationDate;

    public Ticket() {
    }

    public Ticket(int id, int userId, TicketType ticketType, Timestamp creationDate) {
        this.id = id;
        this.userId = userId;
        this.ticketType = ticketType;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (userId != ticket.userId) return false;
        if (ticketType != ticket.ticketType) return false;
        return Objects.equals(creationDate, ticket.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (ticketType != null ? ticketType.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", userId=" + userId +
               ", ticketType=" + ticketType +
               ", creationDate=" + creationDate +
               '}';
    }
}