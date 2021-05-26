package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
    Customer findByName(String name);
}
