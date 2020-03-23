package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();

    ProductDto findOneProduct(Long l);

    ProductDto saveProduct(ProductDto command);

    void deleteProduct(Long idToDelete);
}
