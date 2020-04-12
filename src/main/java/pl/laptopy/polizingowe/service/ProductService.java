package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProducts();

    ProductDto findOneProduct(Long l);

    ProductDto saveProduct(ProductDto command);

    void deleteProduct(Long idToDelete);
}
