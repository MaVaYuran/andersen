package hibernate.entity;

import homework.TicketType;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "ticket_type")
    private TicketType ticketType;
    @Column(name = "creation_date")
    private Timestamp creationDate;

    public Ticket() {
    }

    public Ticket(int userId, TicketType ticketType) {
        this.userId = userId;
        this.ticketType = ticketType;

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
