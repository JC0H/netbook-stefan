package pl.laptopy.polizingowe.repository;

import org.springframework.data.repository.CrudRepository;
import pl.laptopy.polizingowe.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
