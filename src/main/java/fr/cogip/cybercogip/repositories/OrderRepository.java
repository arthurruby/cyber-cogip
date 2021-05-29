package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByReference(String reference);
}
