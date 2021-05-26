package fr.cogip.cybercogip.data;

import fr.cogip.cybercogip.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
