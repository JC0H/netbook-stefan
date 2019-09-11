package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository
        extends CrudRepository<Product, Long>
{
    Optional<List<Product>> findAllByBrand(String brand);
}
