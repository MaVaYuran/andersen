package by.mariayuran.hibernate.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "creation_date")
    private LocalDate creationDate;
    @Transient
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Ticket> userTickets;
    @Transient
    @Enumerated(EnumType.STRING)
    UserStatus status;


    public User(String name, LocalDate creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Ticket> getUserTickets() {
        return userTickets;
    }

    public void setUserTickets(List<Ticket> userTickets) {
        this.userTickets = userTickets;
    }

    public User() {

    }
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(creationDate, user.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", creationDate=" + creationDate +
               '}';
    }
}
