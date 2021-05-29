package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct, Long> {
}
