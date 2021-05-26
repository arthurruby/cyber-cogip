package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
