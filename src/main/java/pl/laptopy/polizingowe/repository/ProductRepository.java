package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.model.Product;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByBrand(String brand);
}
