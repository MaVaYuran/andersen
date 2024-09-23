package jdbc.pojo;

import java.sql.Timestamp;
import java.util.Objects;

public class Users  {
    private int id;
    private String name;
    private Timestamp creationDate;

    public Users() {

    }

    public Users(int id, String name, Timestamp creationDate) {
       this.id = id;
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

        Users users = (Users) o;

        if (id != users.id) return false;
        if (!Objects.equals(name, users.name)) return false;
        return Objects.equals(creationDate, users.creationDate);
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
