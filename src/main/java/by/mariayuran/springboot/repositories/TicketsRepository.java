package by.mariayuran.springboot.repositories;

import by.mariayuran.springboot.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepository extends CrudRepository<Ticket, Integer> {
}
