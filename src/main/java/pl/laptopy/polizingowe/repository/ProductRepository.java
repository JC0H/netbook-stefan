package pl.laptopy.polizingowe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.laptopy.polizingowe.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
