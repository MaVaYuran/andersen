package hibernate.entity;

import homework.TicketType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type", columnDefinition = "ticket_type")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private TicketType ticketType;
    @Column(name = "creation_date")
    private LocalDate creationDate;

    public Ticket() {
    }

    public Ticket(User user, TicketType ticketType, LocalDate creationDate) {
        this.user = user;
        this.ticketType = ticketType;
        this.creationDate = creationDate;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (!Objects.equals(user, ticket.user)) return false;
        if (ticketType != ticket.ticketType) return false;
        return Objects.equals(creationDate, ticket.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (ticketType != null ? ticketType.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", user=" + user +
               ", ticketType=" + ticketType +
               ", creationDate=" + creationDate +
               '}';
    }
}
