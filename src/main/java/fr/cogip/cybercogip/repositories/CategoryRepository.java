package fr.cogip.cybercogip.repositories;

import fr.cogip.cybercogip.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByLabel(String label);
}
