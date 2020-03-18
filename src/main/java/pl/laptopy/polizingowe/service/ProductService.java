package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product findById(Long l);

    ProductDto findCommandById(Long l);

    ProductDto saveProductCommand(ProductDto command);

    void deleteById(Long idToDelete);
}
