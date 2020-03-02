package pl.laptopy.polizingowe.service;

import pl.laptopy.polizingowe.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getAllProduct();

}
