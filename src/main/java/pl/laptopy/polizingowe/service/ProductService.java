package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.model.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> findById(Long id);

    Product save(Product product);

    Product findByProcessor(Product product);

    Product findByGraphics(Product product);

    Product findByMemory(Product product);

    Product findByScreen(Product product);

    Product findByHardDriveCapacity(Product product);

    Product findByRam(Product product);

    Product findByModel(Product product);
}
