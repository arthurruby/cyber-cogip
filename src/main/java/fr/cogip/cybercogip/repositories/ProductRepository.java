package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.Category;
import fr.cogip.cybercogip.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);
    List<Product> findAllByCategory(Category category);
}
